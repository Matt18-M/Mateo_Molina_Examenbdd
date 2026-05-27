--Parte 4
CREATE TABLE proyectos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dias_estimados INTEGER NOT NULL CHECK (dias_estimados > 0)
);

-- Tabla: tecnologias
CREATE TABLE tecnologias (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    categoria VARCHAR(30) NOT NULL
);