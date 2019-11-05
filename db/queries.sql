-- RECETAS POR CADA PERIODO EXISTENTE
select * from periodo;
select p.periodo , r.nombre from receta r, periodo p, receta_periodo rp
where rp.id_receta = r.id_receta and rp.id_periodo = p.id_periodo; -- todas

select p.periodo , r.nombre from receta r, periodo p, receta_periodo rp
where rp.id_receta = r.id_receta and rp.id_periodo = p.id_periodo
and p.id_periodo = 1; -- desayuno

select p.periodo , r.nombre from receta r, periodo p, receta_periodo rp
where rp.id_receta = r.id_receta and rp.id_periodo = p.id_periodo
and p.id_periodo = 2; -- comida

select p.periodo , r.nombre from receta r, periodo p, receta_periodo rp
where rp.id_receta = r.id_receta and rp.id_periodo = p.id_periodo
and p.id_periodo = 3; -- cena

-- INGREDIENTES DE LA RECETA SELECCIONADA
select r.nombre, ri.cantidad, m.medida, i.nombre
from receta r, ingrediente i, receta_ingrediente ri, medida m
where ri.id_receta=r.id_receta and ri.id_medida=m.id_medida and ri.id_ingrediente=i.id_ingrediente
and ri.id_receta=5;-- 2,3,4,5

-- OBTENER EL LAYOUT DE UN USUARIO (en este caso solo hay un registro)
select u.nombre,l.layout, ul.fecha
from usuario_layout ul inner join layout l on l.id_layout = ul.id_layout
inner join usuario u on ul.id_usuario = u.id_usuario;

-- OBTENER EL LAYOUT SEMANAL DE UN USARIO
select du.dia_semana,   p.periodo, r.nombre
from dietapp.combo_dieta_usuario cdu
inner join dieta_usuario du on du.id_dieta_usuario = cdu.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo
inner join receta r on rp.id_receta = r.id_receta
inner join periodo p on rp.id_periodo=p.id_periodo
where du.id_usuario = 2
order by du.dia_semana;

-- INGREDIENTES DE LAS RECETAS DE LA SEMANA (licuado, tacos, tostadas)
select distinct r.nombre, ri.cantidad, m.medida, i.nombre
from dietapp.combo_dieta_usuario cdu
inner join dieta_usuario du on cdu.id_dieta_usuario = du.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo=rp.id_receta_periodo
inner join receta r on rp.id_receta=r.id_receta
inner join receta_ingrediente ri on r.id_receta=ri.id_receta
inner join ingrediente i on ri.id_ingrediente=i.id_ingrediente
inner join medida m on ri.id_medida =m.id_medida
where du.id_usuario =2
order by r.nombre;

