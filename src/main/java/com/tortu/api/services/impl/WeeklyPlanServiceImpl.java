package com.tortu.api.services.impl;

import com.tortu.api.daos.CommonDao;
import com.tortu.api.dto.WPIngredientResultDTO;
import com.tortu.api.dto.WPResultDTO;
import com.tortu.api.models.ComboDietaUsuario;
import com.tortu.api.models.DayEnum;
import com.tortu.api.models.DietaUsuario;
import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.rest.resources.*;
import com.tortu.api.services.*;
import com.tortu.api.utils.GeneralException;
import com.tortu.api.utils.pdf.PdfCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementacion de los servicios de WeeklyPlan
 */
@Service
public class WeeklyPlanServiceImpl implements WeeklyPlanService  {
    private static final Logger LOG = LoggerFactory.getLogger(WeeklyPlanServiceImpl.class);
    @Autowired
    private UsuarioLayoutService usuarioLayoutService;
    @Autowired
    private DietaUsuarioService dietaUsuarioService;
    @Autowired
    private RecetaPeriodoService recetaPeriodoService;
    @Autowired
    private ComboDietaUsuarioService comboDietaUsuarioService;
    @Autowired
    private CommonDao commonDao;

    @Autowired
    private PdfCreator pdfCreator;

    private static final int BREAKFAST_MEAL_PERIOD_ID = 1;
    private static final int LUNCH_MEAL_PERIOD_ID = 2;
    private static final int DINNER_MEAL_PERIOD_ID = 3;

    @Override
    public void saveWeeklyPlan(WeeklyPlanResource weeklyPlanResource) throws GeneralException {
        LOG.info("Creando nuevo WeeklyPlan...");
        // PASO 1 = Crear el procedimiento de eliminar todos los registros de COMBO_DIETA_USUARIO donde el id_dieta_usuario corresponda al id_usuario
        LOG.info("1. Eliminando informacion anterior");
        deleteCurrentWeeklyPlanInfoByUserId(weeklyPlanResource.getUserId());

        // PASO 2 = Crear USUARIO_LAYOUT con la fecha de la semana actual (default)
        LOG.info("2. Creando UsuarioLayout");
        UsuarioLayout usuarioLayout = buildUsuarioLayout(weeklyPlanResource.getUserId(), weeklyPlanResource.getLayoutId(), new Date());
        usuarioLayoutService.saveUsuarioLayout(usuarioLayout);

        // PASO 3 = Crear DIETA_USUARIO (default 5 L-V) con el id_usuario y cada uno de los dias de la semana
        LOG.info("3. Creando DietaUsuario");
        for(DayEnum day : DayEnum.values()){
            DietaUsuario dietaUsuario = buildDietaUsuario(weeklyPlanResource.getUserId(), day.getId());
            dietaUsuarioService.saveDietaUsuario(dietaUsuario);
        }

        // PASO 4 = Obtener lista de id_receta_periodo (RECETA_PERIODO) de cada una de las recetas elegidas(recipeId) para cada periodo (periodId)
        // Crear una linkedList lista de las recetas por cada periodo
        LOG.info("4. Creando listas por periodo y recetas");
        List<WeeklyPlanPeriodRecipeResource> wpPeriodRecipeResourceList = weeklyPlanResource.getWeeklyPlanPeriodRecipes();
        List<Integer> bRecipeList = new ArrayList<>();
        LinkedList<Integer> breakfastRecipeIdList = new LinkedList<Integer>();
        LinkedList<Integer> lunchRecipeIdList = new LinkedList<Integer>();
        LinkedList<Integer> dinnerRecipeIdList = new LinkedList<Integer>();
        // por cada periodo se obtien el id y se busca la lista de recetas que incluye
        for(WeeklyPlanPeriodRecipeResource wpPeriodRecipe : wpPeriodRecipeResourceList){
            Integer periodId = wpPeriodRecipe.getPeriodId(); // id del periodo
            if(periodId==BREAKFAST_MEAL_PERIOD_ID){//desayuno
                for(WeeklyPlanRecipeResource wpRecipe: wpPeriodRecipe.getWeeklyPlanRecipes()){
                    bRecipeList.add(wpRecipe.getRecipeId()); // se agrega el id de la receta a la lista
                }
                breakfastRecipeIdList.addAll(recetaPeriodoService.getRecetaPeriodoIdList(periodId, bRecipeList));
                bRecipeList.clear();
            }else if(periodId==LUNCH_MEAL_PERIOD_ID){//Comida
                for(WeeklyPlanRecipeResource wpRecipe: wpPeriodRecipe.getWeeklyPlanRecipes()){
                    bRecipeList.add(wpRecipe.getRecipeId()); // se agrega el id de la receta a la lista
                }
                lunchRecipeIdList.addAll(recetaPeriodoService.getRecetaPeriodoIdList(periodId, bRecipeList));
                bRecipeList.clear();
            }else if(periodId==DINNER_MEAL_PERIOD_ID){//Cena
                for(WeeklyPlanRecipeResource wpRecipe: wpPeriodRecipe.getWeeklyPlanRecipes()){
                    bRecipeList.add(wpRecipe.getRecipeId()); // se agrega el id de la receta a la lista
                }
                dinnerRecipeIdList.addAll(recetaPeriodoService.getRecetaPeriodoIdList(periodId, bRecipeList));
                bRecipeList.clear();
            }
        }

         // PASO 5 = Crear COMBO_DIETA_USUARIO con RECETA_PERIODO y DIETA_USUARIO
        LOG.info("5. Creando ComboDietaUsuario");
        List<Integer> dietaUsuarioIdList = dietaUsuarioService.getDietaUsuarioIdListByUser(weeklyPlanResource.getUserId());
        for(Integer dietaUsuarioId : dietaUsuarioIdList){ // para cada dia de la semana (5 L-V)
            if(weeklyPlanResource.getLayoutId()==1){ // BLD - se agrega una receta para cada periodo
                Integer recipeIdElement;
                recipeIdElement = breakfastRecipeIdList.pollFirst();
                comboDietaUsuarioService.saveComboDietaUsuario(buildComboDietaUsuario(dietaUsuarioId, recipeIdElement));
                breakfastRecipeIdList.addLast(recipeIdElement);
                recipeIdElement = lunchRecipeIdList.pollFirst();
                comboDietaUsuarioService.saveComboDietaUsuario(buildComboDietaUsuario(dietaUsuarioId, recipeIdElement));
                lunchRecipeIdList.addLast(recipeIdElement);
                recipeIdElement = dinnerRecipeIdList.pollFirst();
                comboDietaUsuarioService.saveComboDietaUsuario(buildComboDietaUsuario(dietaUsuarioId,recipeIdElement));
                dinnerRecipeIdList.addLast(recipeIdElement);
            }
        }
    }

    @Override
    public List<WPWeekDayResultResource> getWeeklyPlan(Integer userId) throws GeneralException {
        LOG.info(String.format("Consultando plan semanal del usuario: %d", userId));
        if(userId==null){
            LOG.error("userId is null");
            throw new GeneralException("El id del usuario es nulo");
        }
        List<WPResultDTO> wpResultDTOList = commonDao.getWeeklyPlanByUser(userId);
        List<WPWeekDayResultResource> weeklyPlanResultList = new ArrayList<>();
        Map<String, WPWeekDayResultResource> map = new LinkedHashMap<>();

        for(WPResultDTO weeklyPlan : wpResultDTOList){
            WPWeekDayResultResource weekDayResource = null;
            if(!map.containsKey(weeklyPlan.getWeekDay())){
                weekDayResource = new WPWeekDayResultResource();
                weekDayResource.setRecipeResultList(new ArrayList<>());
                map.put(weeklyPlan.getWeekDay(), weekDayResource);
            } else {
                weekDayResource = map.get(weeklyPlan.getWeekDay());
            }
            List<WPRecipeResultResource> recipeResultList = new ArrayList<>();
            WPRecipeResultResource wpRecipeResultResource = new WPRecipeResultResource();

            List<WPIngredientResultResource> ingredientResultList = new ArrayList<>();
            List<WPIngredientResultDTO> wpIngredientDTOList = commonDao.getRecipeIngredients(weeklyPlan.getRecipeId());

            for(WPIngredientResultDTO wpIngredientResultDTO : wpIngredientDTOList){
                WPIngredientResultResource wpIngredientResultResource = new WPIngredientResultResource();
                wpIngredientResultResource.setQuantity(wpIngredientResultDTO.getQuantity());
                wpIngredientResultResource.setUnit(wpIngredientResultDTO.getUnit());
                wpIngredientResultResource.setItem(wpIngredientResultDTO.getItem());
                ingredientResultList.add(wpIngredientResultResource);
            }
            wpRecipeResultResource.setRecipeName(weeklyPlan.getRecipeName());
            wpRecipeResultResource.setPeriod(weeklyPlan.getPeriodName());
            wpRecipeResultResource.setIngredientResultList(ingredientResultList);

            recipeResultList.add(wpRecipeResultResource);

            weekDayResource.getRecipeResultList().addAll(recipeResultList);
            weekDayResource.setWeekDay(weeklyPlan.getWeekDay());

//            weeklyPlanResultList.add(weekDayResource);
        }

        weeklyPlanResultList= map.entrySet().stream().map(weekDayPlan -> weekDayPlan.getValue()).collect(Collectors.toList());

        return weeklyPlanResultList;
    }

    @Override
    public InputStream printPdf(Integer userId) throws GeneralException, IOException {
        if(userId==null){
            throw new GeneralException("El Id del usuario es nulo");
        }
        LOG.info("Obteniendo weeklyPLan");
        List<WPWeekDayResultResource> weekDayResult = getWeeklyPlan(userId);
        if(CollectionUtils.isEmpty(weekDayResult)){
            LOG.info("LLista de WPWeeklyDayResultResource vacia o nula");
            return null;
        }
        return pdfCreator.createPDF(weekDayResult);
    }

    /**
     * Crea un objeto UsuarioLayout
     * @param idUsuario id del usuario
     * @param idLayout id del layout
     * @param fecha fecha default (dia de hoy)
     * @return objeto creado con la informacion enviada
     */
    private UsuarioLayout buildUsuarioLayout(Integer idUsuario, Integer idLayout, Date fecha){
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        usuarioLayout.setFecha(fecha);
        usuarioLayout.setIdLayout(idLayout);
        usuarioLayout.setIdUsuario(idUsuario);
        return usuarioLayout;
    }

    /**
     * Crea un objeto DietaUsuario
     * @param idUsuario id del usuario
     * @param dia dia de la semana
     * @return objeto creada con la info enviada
     */
    private DietaUsuario buildDietaUsuario(Integer idUsuario, String dia){
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdUsuario(idUsuario);
        dietaUsuario.setDiaSemana(dia);
        return  dietaUsuario;
    }

    /**
     * Crea un objeto ComboDietaUsuario
     * @param dietaUsuarioId id dieta_usuario
     * @param recetaPeriodoId id receta_periodo
     * @return objeto creado
     */
    private ComboDietaUsuario buildComboDietaUsuario(Integer dietaUsuarioId, Integer recetaPeriodoId){
        ComboDietaUsuario comboDietaUsuario = new ComboDietaUsuario();
        comboDietaUsuario.setIdDietaUsuario(dietaUsuarioId);
        comboDietaUsuario.setIdRecetaPeriodo(recetaPeriodoId);
        return comboDietaUsuario;
    }

    /**
     * Elimina la informacion actual en COMBO_DIETA_USUARIO para el id enviado
     * @param userId id del usuario para elimar la informacion actual de combo_dieta_usuario
     */
    private void deleteCurrentWeeklyPlanInfoByUserId(Integer userId){
        LOG.info("...eliminando informacion actual del usuario");
        // Obtener lista de Ids de DIETA_USUARIO que contengan el user id enviado
        List<Integer> dietaUsuarioIdList = dietaUsuarioService.getDietaUsuarioIdListByUser(userId);
        if(! CollectionUtils.isEmpty(dietaUsuarioIdList)){ //si la lista no esta vacia
            // Obtener lista de Ids de COMBO_DIETA_USUARIO que contengan los ids de dieta_usuario obtenidos
            List<Integer> comboDietaUsuarioIdList = comboDietaUsuarioService.getComboDietaUsuarioIdsByDietaUsuario(dietaUsuarioIdList);
            // Eliminar cada uno de los registros de COMBO_DIETA con id_dieta_usuario que venga en la lista obtenida
            for(Integer id:comboDietaUsuarioIdList){
                comboDietaUsuarioService.deleteComboDietaUsuario(id);
            }
            //Eliminar cada uno de los registros de DIETA_USUARIO para el usuario enviado
            for(Integer id : dietaUsuarioIdList){
                dietaUsuarioService.deleteDietaUsuario(id);
            }
        }
    }

}
