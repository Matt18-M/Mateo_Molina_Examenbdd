Examen Práctico Evaluativo: Taller de Desarrollo Backend

Este proyecto corresponde al examen práctico del Taller de Desarrollo Backend.
Se implementa una API REST completa para gestionar vuelos utilizando Spring Boot, JPA/Hibernate y PostgreSQL.

**Parte 1 – PostgreSQL**

En esta sección se creó el modelo de base de datos inicial:

Tabla vuelos con sus columnas y restricciones (PK, NOT NULL, CHECK, UNIQUE).
20 registros insertados para pruebas.
Consultas solicitadas:
SELECT (filtros, ordenamientos, búsquedas)
UPDATE (actualización de precios, destinos, etc.)
DELETE (eliminar vuelos según condiciones)


**Parte 2 – API REST con Spring Boot (CRUD completo)**

Se implementó una API RESTful para gestionar la entidad Vuelo.

Endpoints principales:
POST – Crear un vuelo
GET – Listar todos o buscar por ID
PUT – Actualizar un vuelo
DELETE – Eliminar un vuelo
Tecnologías utilizadas:
@Entity, @Repository, @Service, @RestController
JPA/Hibernate con JpaRepository
Manejo de JSON desde Postman
Validaciones básicas y manejo de errores

Video explicativo:
https://drive.google.com/drive/folders/15qSAdrwtl5FuLXiv_xVDNmAquU8HWMU6?usp=sharing

**Parte 3 – Mantenimiento y Extensibilidad (Modificación de Requisitos)**

En esta sección se aplicó un cambio de requisitos al sistema existente: añadir el campo “destino” a los vuelos.
El objetivo fue extender la arquitectura sin alterar su funcionamiento general.

1. Base de Datos
Se actualizó la tabla de vuelos para agregar el nuevo atributo destino, asegurando que la información pueda almacenarse correctamente en PostgreSQL.

2. Entidad Java (Vuelo.java)
Se incorporó el nuevo campo dentro del modelo de dominio para que forme parte del objeto Vuelo y pueda ser gestionado por Hibernate.

3. Servicios y Controladores
Se adaptó la lógica del CRUD para que el sistema reciba, procese y guarde el nuevo dato tanto al crear como al actualizar un vuelo.

4. Validación en Postman
Se ajustaron los JSON enviados desde el cliente para incluir el nuevo campo destino en todas las peticiones pertinentes (POST y PUT).

**Parte 4 – Relaciones Muchos a Muchos (PostgreSQL)**
En esta parte se modeló una relación N:M entre:

proyectos
tecnologías
Se crearon 3 tablas:
proyectos – Tabla maestra con información de cada proyecto.
tecnologias – Tabla maestra con nombres y categorías.
proyectos_tecnologias – Tabla intermedia (rompimiento) con:
Llave primaria compuesta (id_proyecto, id_tecnologia)
Llaves foráneas para mantener integridad
Evita duplicados entre combinaciones proyecto–tecnología
Consultas JOIN realizadas:
Obtener tecnologías utilizadas en un proyecto.
Obtener proyectos que usan una tecnología específica.
Generar un reporte consolidado de cuántos proyectos usan cada tecnología.

