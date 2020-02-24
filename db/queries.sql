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

select p.periodo , r.nombre from receta r, periodo p, receta_periodo rp
where rp.id_receta = r.id_receta and rp.id_periodo = p.id_periodo
and p.id_periodo = 4; -- snack matutino

select p.periodo , r.nombre from receta r, periodo p, receta_periodo rp
where rp.id_receta = r.id_receta and rp.id_periodo = p.id_periodo
and p.id_periodo = 5; -- sncak vespertino

-- select * from receta;
-- INGREDIENTES DE LA RECETA SELECCIONADA
/**
2	Chia Puddin
3	Licuado
4	Tacos de tilapia
5	Tostada de champinon
6	Faitas de pollo
7	sopa de apio
8	huevo
9	sandwich
10	Nueces y fresas
11	gelatina sin azucar
12	palomitas
13	Avena
 */
select r.nombre, ri.cantidad, m.medida, i.nombre
from receta r, ingrediente i, receta_ingrediente ri, medida m
where ri.id_receta=r.id_receta and ri.id_medida=m.id_medida and ri.id_ingrediente=i.id_ingrediente
and ri.id_receta=6;-- 2,3,4,5

-- OBTENER EL LAYOUT DE LOS USUARIOS
select u.nombre,l.layout, ul.fecha
from usuario_layout ul inner join layout l on l.id_layout = ul.id_layout
inner join usuario u on ul.id_usuario = u.id_usuario;

-- OBTENER EL MENU (la dieta) SEMANAL DE UN USARIO
select du.dia_semana,   p.periodo, r.nombre
from dietapp.combo_dieta_usuario cdu
inner join dieta_usuario du on du.id_dieta_usuario = cdu.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo
inner join receta r on rp.id_receta = r.id_receta
inner join periodo p on rp.id_periodo=p.id_periodo
where du.id_usuario = 4
order by du.dia_semana;

-- INGREDIENTES DE LAS RECETAS DE LA SEMANA (licuado, tacos, tostadas)
select r.nombre, sum(ri.cantidad), m.medida, i.id_ingrediente,i.nombre
from dietapp.combo_dieta_usuario cdu
inner join dieta_usuario du on cdu.id_dieta_usuario = du.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo=rp.id_receta_periodo
inner join receta r on rp.id_receta=r.id_receta
inner join receta_ingrediente ri on r.id_receta=ri.id_receta
inner join ingrediente i on ri.id_ingrediente=i.id_ingrediente
inner join medida m on ri.id_medida =m.id_medida
where du.id_usuario =4
group by i.id_ingrediente
order by r.nombre;

-- INGREDIENTES DE LAS RECETAS DE LA SEMANA (licuado, tacos, tostadas)
select r.id_receta, r.nombre, sum(ri.cantidad), m.medida, i.id_ingrediente,i.nombre
from dietapp.combo_dieta_usuario cdu
inner join dieta_usuario du on cdu.id_dieta_usuario = du.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo=rp.id_receta_periodo
inner join receta r on rp.id_receta=r.id_receta
inner join receta_ingrediente ri on r.id_receta=ri.id_receta
inner join ingrediente i on ri.id_ingrediente=i.id_ingrediente
inner join medida m on ri.id_medida =m.id_medida
where du.id_usuario =4
group by i.id_ingrediente
order by r.nombre;

-- INGREDIENTES DE LAS RECETAS DE LA SEMANA (licuado, tacos, tostadas)
select sum(ri.cantidad), m.medida,i.nombre, i.id_ingrediente
from dietapp.combo_dieta_usuario cdu
inner join dieta_usuario du on cdu.id_dieta_usuario = du.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo=rp.id_receta_periodo
inner join receta r on rp.id_receta=r.id_receta
inner join receta_ingrediente ri on r.id_receta=ri.id_receta
inner join ingrediente i on ri.id_ingrediente=i.id_ingrediente
inner join medida m on ri.id_medida =m.id_medida
where du.id_usuario =4
group by i.id_ingrediente;

-- INGREDIENTES DE LAS RECETAS DE LA SEMANA
-- Suma de los ingredientes para las recetas de la semana, ordenado por ingrediente/medida
select r.nombre, sum(ri.cantidad), m.medida,i.nombre
from dietapp.combo_dieta_usuario cdu
inner join dieta_usuario du on cdu.id_dieta_usuario = du.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo=rp.id_receta_periodo
inner join receta r on rp.id_receta=r.id_receta
inner join receta_ingrediente ri on r.id_receta=ri.id_receta
inner join ingrediente i on ri.id_ingrediente=i.id_ingrediente
inner join medida m on ri.id_medida =m.id_medida
where du.id_usuario =4
group by i.id_ingrediente, m.medida
order by i.nombre;

-- 20200221
-- OBTENER EL MENU (la dieta) SEMANAL DE UN USARIO
select du.dia_semana,   p.periodo, r.nombre
from  combo_dieta_usuario cdu
inner join dieta_usuario du on du.id_dieta_usuario = cdu.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo
inner join receta r on rp.id_receta = r.id_receta
inner join periodo p on rp.id_periodo=p.id_periodo
where du.id_usuario = 4
order by du.dia_semana;

-- Recetas de la semana para un usuario y suma de las veces que aparece en la semana
select p.periodo , r.nombre as 'Receta', count (r.nombre ) as 'Dias a la semana'
from  combo_dieta_usuario cdu
inner join dieta_usuario du on du.id_dieta_usuario = cdu.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo
inner join receta r on rp.id_receta = r.id_receta
inner join periodo p on rp.id_periodo=p.id_periodo
where du.id_usuario = 4
group by r.nombre
order by p.id_periodo ;

select * from receta r ;

-- Ingredientes de UNA SOLA receta
select r.nombre as 'Receta' , i.nombre as 'Ingrediente', ri.cantidad , m.medida as 'Medida'
from receta_ingrediente ri
inner join receta r on ri.id_receta = r.id_receta
inner join ingrediente i on ri.id_ingrediente = i.id_ingrediente
inner join medida m on ri.id_medida = m.id_medida
where ri.id_receta = 3; -- (2- Chia puddin) (13-avena) (3-licuado)

-- Ingredientes de TODAS LAS RECETAS para TODOS LOS DIAS de la semana de un usuario
select  r.nombre as 'Receta' , ri.cantidad,m.medida , i.nombre as 'Ingrediente'
from  combo_dieta_usuario cdu
inner join dieta_usuario du on cdu.id_dieta_usuario =du.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo
inner join receta r on rp.id_receta =r.id_receta
inner join receta_ingrediente ri on r.id_receta =ri.id_receta
inner join medida m on ri.id_medida =m.id_medida
inner join ingrediente i on ri.id_ingrediente =i.id_ingrediente
where du.id_usuario = 4
order by r.nombre, i.nombre ;

-- Suma de los ingredientes POR RECETA, para toda la semana
select  r.nombre as 'Receta' , sum(ri.cantidad) ,m.medida , i.nombre as 'Ingrediente'
from  combo_dieta_usuario cdu
inner join dieta_usuario du on cdu.id_dieta_usuario =du.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo
inner join receta r on rp.id_receta =r.id_receta
inner join receta_ingrediente ri on r.id_receta =ri.id_receta
inner join medida m on ri.id_medida =m.id_medida
inner join ingrediente i on ri.id_ingrediente =i.id_ingrediente
where du.id_usuario = 4
group by r.nombre, m.medida , i.nombre
order by i.nombre ;

select  r.nombre as 'Receta' , sum(ri.cantidad) ,m.medida , i.nombre as 'Ingrediente'
from  combo_dieta_usuario cdu
inner join dieta_usuario du on cdu.id_dieta_usuario =du.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo
inner join receta r on rp.id_receta =r.id_receta
inner join receta_ingrediente ri on r.id_receta =ri.id_receta
inner join medida m on ri.id_medida =m.id_medida
inner join ingrediente i on ri.id_ingrediente =i.id_ingrediente
where du.id_usuario = 4 and i.nombre = 'fresas'
group by r.nombre, m.medida , i.nombre
order by i.nombre ;

-- Lista de compras (ingredientes TOTALES) para la semana
select sum(ri.cantidad) as 'Cantidad' ,m.medida , i.id_ingrediente , i.nombre as 'Ingrediente', ci.nombre as'Categoria'
from  combo_dieta_usuario cdu
inner join dieta_usuario du on cdu.id_dieta_usuario =du.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo
inner join receta r on rp.id_receta =r.id_receta
inner join receta_ingrediente ri on r.id_receta =ri.id_receta
inner join medida m on ri.id_medida =m.id_medida
inner join ingrediente i on ri.id_ingrediente =i.id_ingrediente
inner join categoria_ingrediente ci on i.id_categoria_ingrediente =ci.id_categoria_ingrediente
where du.id_usuario = 4
group by m.medida , i.nombre
order by ci.nombre, i.nombre ;

-- -----------------------------------------------------------------------------------------------------------------------

/**
 * SELECT distinct
CASE
WHEN dia_semana = 'lunes' THEN 1
	WHEN dia_semana = 'martes' THEN 2
	WHEN dia_semana = 'miercoles' THEN 3
	WHEN dia_semana = 'jueves' THEN 4
	WHEN dia_semana = 'viernes' THEN 5
	WHEN dia_semana = 'sabado' THEN 6
	WHEN dia_semana = 'domingo' THEN 7
	else 0
END weekorder
FROM dieta_usuario du
order by weekorder ;
 */

-- OBTENER EL MENU (la dieta) SEMANAL DE UN USARIO *En Orden*
select du.dia_semana,   p.periodo, r.nombre
from  combo_dieta_usuario cdu
inner join dieta_usuario du on du.id_dieta_usuario = cdu.id_dieta_usuario
inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo
inner join receta r on rp.id_receta = r.id_receta
inner join periodo p on rp.id_periodo=p.id_periodo
where du.id_usuario = 4
order by FIELD(du.dia_semana , "lunes", "martes", "miercoles", "jueves", "viernes", "sabado","doming");



