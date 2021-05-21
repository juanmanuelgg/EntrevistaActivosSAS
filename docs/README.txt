Entrevista labolar para Activos S.A.S de Juan Manuel González Garzón

Este proyecto cumple la siguiente especificación:

Según su conocimiento en desarrollo de aplicaciones cree una que cumpla con los siguientes ítems:
- Conectarse a una base de datos. 		// Tipo MySQL, creada en el archivo create-database.sql, conección en /activos/src/main/resources/application.properties
- Creación de un modelo de tablas.		// En el archivo create-database.sql y se pobla en el archivos insert-data.sql
- CRUD a la base de datos.			// En la aplicación, en los archivos Topic.java, ITopicRepository, TopicController, TopicService

# --------------------------------------- Sin completar --------------------------------------------------
- Creación de un procedimiento almacenado	// En el archivo create-database.sql
- Creación de una función			// En el archivo create-database.sql
# --------------------------------------------------------------------------------------------------------

- Listas desplegables.				// En la aplicación, cliente web				<<= visible en la url:http://localhost:8080/index.html

# --------------------------------------- Sin completar --------------------------------------------------
- Mensajes de alerta.				// En la aplicación, cliente web
- Manejo de errores.				// En la aplicación
- Documentación de la aplicación.		// Usando el jar: spring-restdocs-core-2.0.5.RELEASE.jar
# --------------------------------------------------------------------------------------------------------

Mejoras a realizar

- Atender este warning:
JpaBaseConfiguration$JpaWebConfiguration spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning