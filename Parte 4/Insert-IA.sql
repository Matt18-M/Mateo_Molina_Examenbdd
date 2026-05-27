--Insert con IA

INSERT INTO proyectos (nombre, dias_estimados)
VALUES 
('Sistema de Ventas Web', 45),
('Aplicación Móvil de Salud', 90),
('Plataforma Educativa Online', 120);

INSERT INTO tecnologias (nombre, categoria)
VALUES
('Java', 'Backend'),
('React', 'Frontend'),
('PostgreSQL', 'Base de Datos');

-- Proyecto 1 usa Java y PostgreSQL
INSERT INTO proyectos_tecnologias (id_proyecto, id_tecnologia)
VALUES 
(1, 1),  -- Sistema de Ventas Web usa Java
(1, 3);  -- Sistema de Ventas Web usa PostgreSQL

-- Proyecto 2 usa Java y React
INSERT INTO proyectos_tecnologias (id_proyecto, id_tecnologia)
VALUES 
(2, 1),  -- App Móvil de Salud usa Java
(2, 2);  -- App Móvil de Salud usa React

-- Proyecto 3 usa React y PostgreSQL
INSERT INTO proyectos_tecnologias (id_proyecto, id_tecnologia)
VALUES
(3, 2),  -- Plataforma Educativa usa React
(3, 3);  -- Plataforma Educativa usa PostgreSQL