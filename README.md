# Foro Hub

## Indice /  Table of Contents

- [Español 🇪🇸](#espa%C3%B1ol-%F0%9F%87%AA%F0%9F%87%B8)
- [English 🇬🇧](#english-%F0%9F%87%AC%F0%9F%87%A7)

## Español 🇪🇸

### Descripción
**Foro Hub** es una API REST diseñada para la gestión de foros de discusión en línea. Permite a los usuarios registrados crear, modificar y eliminar tópicos (temas). Además, implementa un sistema de autenticación para garantizar que solo los usuarios autenticados puedan acceder a las funcionalidades.

### Características principales
- **Gestión de tópicos:** Crear, actualizar, listar y eliminar tópicos.
- **Autenticación segura:** Solo los usuarios autenticados tienen acceso a los endpoints.
- **Base de datos MySQL:** Conexión estable y eficiente para almacenar datos de usuarios y tópicos.
- **Desarrollado con Spring Boot 3:** Utiliza las últimas características de este framework.

### Requisitos previos
Antes de instalar el proyecto, asegúrate de tener:
- **Java 17** o superior.
- **Maven** (para gestionar dependencias).
- **MySQL** instalado y configurado.
- Un entorno de desarrollo como IntelliJ IDEA o Eclipse.

Tambies puedes correr el proyecto teniendo: 
- **Docker** y **Docker Compose** instalados.


### Instalación

#### Opcion 1: Usando Docker
1. Clona este repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_REPOSITORIO>
   ```

2. Construye y levanta los contenedores con Docker Compose:
    ```bash
    docker-compose up --build
    ```

3. Accede a  la API:
    - URL base: `http://localhost:8080`
    - Swagger UI: `http://localhost:8080/swagger-ui.html`

¡Eso es todo! Los contenedores incluyen la base de datos MySQL configurada y la API.

#### Opcion 2: Instalacion manual
1. Clona este repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_REPOSITORIO>
   ```

2. Configura la base de datos MySQL:
    - Crea una base de datos llamada `foro_hub`.
    - Configura las credenciales en `application.properties` o `application-prod.properties`.

3. Ejecuta el archivo JAR del proyecto:
   ```bash
   java -jar target/<NOMBRE_DEL_SNAPSHOT>.jar
   ```

4. Accede a la API:
    - URL base: `http://localhost:8080`.
    - Swagger UI: `http://localhost:8080/swagger-ui.html`.

### Uso
- Usa herramientas como **Postman** o **cURL** para interactuar con los endpoints.
- Consulta la documentación de la API en **Swagger UI**.

### Tecnologías utilizadas
- **Spring Boot 3**
- **MySQL**
- **JWT** para autenticación
- **Swagger/OpenAPI** para documentación de la API
- **Docker** para contenerización

---

## English En

### Description
**Foro Hub** is a REST API designed for managing online discussion forums. It allows registered users to create, update, list, and delete topics. Additionally, it implements an authentication system to ensure that only authenticated users can access the functionalities.

### Key Features
- **Topic Management:** Create, update, and delete topics.
- **Secure Authentication:** Only authenticated users can access the endpoints.
- **MySQL Database:** Stable and efficient connection to store user and topic data.
- **Built with Spring Boot 3:** Leverages the latest features of this framework.
- **Containerization with Docker:** Easy deployment using Docker containers.

### Prerequisites
Before installing the project, make sure you have:
- **Docker** and **Docker Compose** installed.

### Installation

#### Option 1: Using Docker
1. Clone this repository:
   ```bash
   git clone <REPOSITORY_URL>
   cd <REPOSITORY_NAME>
   ```
2. Build and start the containers with Docker Compose:
   ```bash
   docker-compose up --build
   ```
3. Access the API:
   - Base URL: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`

That’s it! The containers include the configured MySQL database and the API.

#### Option 2: Manual Installation
1. Clone this repository:
   ```bash
   git clone <REPOSITORY_URL>
   cd <REPOSITORY_NAME>
   ```
2. Set up the MySQL database:
   - Create a database named `foro_hub`.
   - Configure the credentials in `application.properties` or `application-prod.properties`.

3. Run the project's JAR file:
   ```bash
   java -jar target/<SNAPSHOT_NAME>.jar
   ```

4. Access the API:
   - Base URL: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`

### Usage
- Use tools like **Postman** or **cURL** to interact with the endpoints.
- Check the API documentation in **Swagger UI**.

### Technologies Used
- **Spring Boot 3**
- **MySQL**
- **JWT** for authentication
- **Swagger/OpenAPI** for API documentation
- **Docker** for containerization