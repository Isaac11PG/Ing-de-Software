# 📌 Proyecto: Sistema de Login con Spring Boot

Este proyecto es una aplicación de autenticación con Spring Boot que permite a los usuarios iniciar sesión de manera segura. La aplicación utiliza una base de datos para gestionar usuarios y contraseñas, y puede ejecutarse con Docker.

---

## 🛠️ Instalación y Ejecución

### 1️⃣ Requisitos Previos
Antes de ejecutar la aplicación, asegúrate de tener instalado:
- [Java 21]([https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html))
- [Maven](https://maven.apache.org/)
- [XAMPP (o MySQL)](https://www.apachefriends.org/es/index.html)
- [Docker & Docker Compose](https://docs.docker.com/get-docker/)

### 2️⃣ Clonar el Repositorio
```sh
 git clone https://github.com/tu-usuario/tu-repositorio.git
 cd tu-repositorio
```

### 3️⃣ Configurar Base de Datos
1. Inicia MySQL (en XAMPP o como servicio).
2. Crea una base de datos llamada **login_db**:
   ```sql
   CREATE DATABASE login_db;
   ```
3. Configura las credenciales en `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/login_db
   spring.datasource.username=root
   spring.datasource.password=tu_contraseña
   ```

### 4️⃣ Ejecutar la Aplicación
Compila y ejecuta con Maven:
```sh
 mvn clean install
 mvn spring-boot:run
```
La aplicación estará disponible en **`http://localhost:8080`**.

---

## 🐳 Despliegue con Docker

### 1️⃣ Crear el archivo `Dockerfile`
Asegúrate de tener un `Dockerfile` en la raíz del proyecto:
```dockerfile
 FROM openjdk:21
 WORKDIR /app
 COPY target/login-app.jar app.jar
 ENTRYPOINT ["java", "-jar", "app.jar"]
```

### 2️⃣ Crear `docker-compose.yml`
Si la aplicación usa MySQL, agrega este archivo en la raíz del proyecto:
```yaml
version: '3.8'
services:
  db:
    image: mysql:8
    container_name: mysql_login
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: tu_contraseña
      MYSQL_DATABASE: login_db
    ports:
      - "3306:3306"

  app:
    build: .
    container_name: spring_login
    restart: always
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/login_db
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: tu_contraseña
    ports:
      - "8080:8080"
```

### 3️⃣ Ejecutar con Docker
```sh
 docker-compose up --build -d
```
Esto iniciará la base de datos y la aplicación en contenedores.

---

## 📷 Capturas de Pantalla
### ✅ Aplicación ejecutándose con Docker:
![image](https://github.com/user-attachments/assets/b1ba2caf-ba10-4732-8975-ee7820136107)

### ✅ Pantalla de login funcionando:
![image](https://github.com/user-attachments/assets/bd41bde7-35ec-4aa0-b3e7-205c59c52420)

### ✅ Creación de cuenta:
![image](https://github.com/user-attachments/assets/9dfe8b8c-c7f3-4b2e-bc62-b464185fb78b)

### ✅ Página de inicio:
![image](https://github.com/user-attachments/assets/ba65e202-63c0-4a73-8c5e-6ed8efb3cca2)

### ✅ Prueba de conexión a la base de datos:
![image](https://github.com/user-attachments/assets/5868083c-dcc6-4188-bc7c-d0b0838e2cef)




