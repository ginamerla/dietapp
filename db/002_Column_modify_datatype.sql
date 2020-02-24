ALTER TABLE receta_ingrediente 
MODIFY COLUMN cantidad decimal(10,2);

UPDATE receta_ingrediente 
SET cantidad = .5
WHERE id_receta_ingrediente = 1;