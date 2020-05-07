package com.tortu.api.daos.impl;

import com.tortu.api.daos.ComboDietaUsuarioDao;
import com.tortu.api.daos.mappers.ComboDietaUsuarioRowMapper;
import com.tortu.api.models.ComboDietaUsuario;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementacion de la capa de acceso a la Base de Datos
 */
@Component
public class ComboDietaUsuarioDaoImpl implements ComboDietaUsuarioDao {
    private static Logger LOG = LoggerFactory.getLogger(ComboDietaUsuarioDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(ComboDietaUsuario model) throws GeneralException {
        LOG.info(String.format("Insertando nuevo ComboDietaUsuario: %s", model));
        int updatedRows = jdbcTemplate.update(SAVE, model.getIdDietaUsuario(), model.getIdRecetaPeriodo());
        if(updatedRows==0){
            LOG.error("No se pudo insertar ComboDietaUsuario en la base de datos");
            throw new GeneralException("El ComboDietaUsuario no se pudo guardar");
        }
        return updatedRows;
    }

    @Override
    public void update(ComboDietaUsuario model) throws GeneralException {
        LOG.info(String.format("Actualizando ComboDietaUsuario: %s",model));
        int updatedRows=jdbcTemplate.update(UPDATE,model.getIdDietaUsuario(), model.getIdRecetaPeriodo(), model.getIdComboDietaUsuario());
        if(updatedRows==0){
            LOG.error("No se pudo actualizar ComboDietaUsuario en la base de datos");
            throw new GeneralException("El ComboDietaUsuario no se pudo actualizar");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        LOG.info(String.format("Eliminando ComboDietaUsuario con id: %d",id));
        int updatedRows=jdbcTemplate.update(DELETE,(id));
        if(updatedRows==0){
            LOG.error("No se pudo eliminar ComboDietaUsuario en la base de datos");
            throw new GeneralException("El ComboDietaUsuario no se pudo eliminar");
        }
    }

    @Override
    public ComboDietaUsuario findByiD(Integer id) throws GeneralException {
        LOG.info(String.format("Consultando ComboDietaUsuario con id: %d",id));
        return jdbcTemplate.queryForObject(FINDBYID, new ComboDietaUsuarioRowMapper(), id);
    }

    @Override
    public List<ComboDietaUsuario> findAll() throws GeneralException {
        LOG.info("Consultando todos los ComboDietaUsuario");
        return jdbcTemplate.query(FIND_ALL, new ComboDietaUsuarioRowMapper());
    }

    @Override
    public List<Integer> findComboDietaUsuarioIdListByDietaUsuario(List<Integer> dietaUsuarioIdList) {
        LOG.info("Consultando lista de IDs en combo_dieta_usuario con lista de dieta_usuario_id enviada");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("ids", dietaUsuarioIdList);
        return namedParameterJdbcTemplate.queryForList(FIND_ID_LIST_BY_DIETA_USUARIO, parameters, Integer.class);
    }
}
