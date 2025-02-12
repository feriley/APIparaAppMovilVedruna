📌 README para la API (Spring Boot + MongoDB)
🚀 Vedruna API
🔹 Backend desarrollado en Spring Boot con base de datos MongoDB para gestionar publicaciones, comentarios, incidencias y usuarios.


📌 Características
✅ CRUD completo para publicaciones, comentarios, incidencias y usuarios.
✅ Gestión de "likes" en publicaciones.
✅ Filtrado de publicaciones por usuario.
✅ Gestión de incidencias con estados (SOLUCIONADO, EN TRÁMITE, DENEGADA).
✅ Integración con React Native.

🛠 Instalación y Configuración


1️⃣ Clonar el Repositorio

git clone 
cd vedruna-api
2️⃣ Configurar MongoDB
Asegúrate de tener MongoDB instalado y en ejecución en localhost:27017. Puedes usar Docker:

3️⃣ Instalar dependencias

mvn clean install
4️⃣ Ejecutar la API

mvn spring-boot:run


🔹 La API estará disponible en:
👉 http://localhost:8080/proyecto01/

🔥 Endpoints Principales
📌 Publicaciones

Método	Endpoint	Descripción
GET	/publicaciones	Obtiene todas las publicaciones
POST	/publicaciones	Crea una nueva publicación
PUT	/publicaciones/put/{id}/{user_id}	Agrega o quita un "like"
📌 Comentarios

Método	Endpoint	Descripción
GET	/comentarios/{id_publicacion}	Obtiene comentarios de una publicación
POST	/comentarios	Agrega un comentario
📌 Incidencias

Método	Endpoint	Descripción
GET	/incidencias	Obtiene todas las incidencias
POST	/incidencias	Crea una nueva incidencia
PUT	/incidencias/{id}/{estado}	Cambia el estado de una incidencia
📌 Usuarios

Método	Endpoint	Descripción
GET	/usuarios/{id}	Obtiene la información del usuario
POST	/usuarios	Registra un usuario


🖥 Herramientas utilizadas
✅ Spring Boot (Framework principal)
✅ MongoDB (Base de datos NoSQL)
✅ Maven (Gestión de dependencias)
✅ Swagger/OpenAPI (Documentación automática)

📌 Autores
👤 Fernando Iglesias (@feriley8)
🔹 Desarrollador Backend & Mobile

📌 Estado del Proyecto
🚀 100% Completo y en producción.
📌 Posibles mejoras:
✔ Autenticación con JWT
✔ Implementar filtros avanzados en MongoDB
✔ Envío de notificaciones por email

