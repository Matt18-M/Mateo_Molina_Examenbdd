--Consultas

--Consulta 1
SELECT *
FROM vuelos
WHERE asientos_disponibles < 5;

--Update
UPDATE vuelos
SET precio_boleto = precio_boleto * 1.15
WHERE id = 3;

--delete
DELETE FROM vuelos
WHERE asientos_disponibles = 0;
