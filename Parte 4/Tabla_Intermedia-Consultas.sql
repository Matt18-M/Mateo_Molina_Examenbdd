--tabla intermedia
CREATE TABLE proyectos_tecnologias (
    id_proyecto INTEGER NOT NULL,
    id_tecnologia INTEGER NOT NULL,

    -- PRIMARY KEY COMPUESTA
    PRIMARY KEY (id_proyecto, id_tecnologia),

    -- Llave foránea a proyectos
    FOREIGN KEY (id_proyecto)
        REFERENCES proyectos(id)
        ON DELETE CASCADE,

    -- Llave foránea a tecnologias
    FOREIGN KEY (id_tecnologia)
        REFERENCES tecnologias(id)
        ON DELETE CASCADE
);

--consultas

--nombre del proyecto
SELECT 
    p.nombre AS proyecto,
    t.nombre AS tecnologia,
    t.categoria
FROM proyectos p
JOIN proyectos_tecnologias pt 
    ON p.id = pt.id_proyecto
JOIN tecnologias t 
    ON t.id = pt.id_tecnologia
WHERE p.nombre = 'Sistema de Ventas Web';

--id de tecnologia
SELECT
    t.nombre AS tecnologia,
    p.nombre AS proyecto,
    p.dias_estimados
FROM tecnologias t
JOIN proyectos_tecnologias pt
    ON t.id = pt.id_tecnologia
JOIN proyectos p
    ON p.id = pt.id_proyecto
WHERE t.id = 1; 

--reporte de uso tecnologico
SELECT
    t.nombre AS tecnologia,
    COUNT(pt.id_proyecto) AS total_proyectos
FROM tecnologias t
LEFT JOIN proyectos_tecnologias pt
    ON t.id = pt.id_tecnologia
GROUP BY t.nombre
ORDER BY total_proyectos DESC;