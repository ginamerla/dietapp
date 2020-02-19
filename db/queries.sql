/**
 *		 PERIODO:
1	Desayuno
2	Comida
3	Cena
4	Snack
		RECETA:
1	Smoothie
2	Banana Bowl
3	Tacos de tilapia
4	Tostadas champinones
 */

use dietapp;
/**
 * Consultar las receta para DESAYUNO (id_periodo 1)
 */
select b.nombre, c.periodo
from dietapp.receta_periodo as a
	inner join dietapp.receta as b on a.id_receta = b.id_receta
	inner join dietapp.periodo as c on a.id_periodo = c.id_periodo
where c.id_periodo=1;

/**
 * Consultar los ingredientes de una receta (Smoothie id_receta=1)
 */
select r.nombre as RECETA, ri.cantidad, m.medida, i.nombre as INGREDIENTE
from receta_ingrediente as ri
	inner join receta as r on ri.id_receta=r.id_receta
	inner join medida as m on ri.id_medida=m.id_medida
	inner join ingrediente as i on ri.id_ingrediente=i.id_ingrediente
where ri.id_receta=3;

/**
 * Consulta los ingredientes de una receta con la categoria del ingrediente
 */

select r.nombre as RECETA, ri.cantidad, m.medida, i.nombre as INGREDIENTE, ci.nombre as CATEGORIA
from receta_ingrediente as ri
	inner join receta as r on ri.id_receta=r.id_receta
	inner join medida as m on ri.id_medida=m.id_medida
	inner join ingrediente as i on ri.id_ingrediente=i.id_ingrediente
	inner join categoria_ingrediente as ci on ri.id_ingrediente=i.id_ingrediente
		and i.id_categoria_ingrediente=ci.id_categoria_ingrediente
where ri.id_receta=1;




select * from dietapp.ingrediente;
select * from dietapp.categoria_ingrediente;
select * from dietapp.receta_ingrediente;
select * from dietapp.medida;
-- update receta_ingrediente set id_medida=4 where id_receta_ingrediente=4;

