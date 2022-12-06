# Charity Sale App using Spring-Boot

Application is built using Java 17, Spring Boot 2.7, Spring Data JPA, Spring Batch and Postgresql.

## Quick start

Back-end application must be started before starting Angular application. Angular application connects with Spring Boot application using proxy config to avoid CORS issues.

### Clone the repository

```
[git clone git@github.com:flavours/getting-started-with-spring-boot.git](https://github.com/codertube/spring-boot-ecommerce.git)
```

### Build the project

```
cd spring-boot-ecommerce
mvn clean install (will build Docker image)
```

The project includes a ``web`` service, running the Java code, and a ``db`` service, running a Postgres database.
See the ``docker-compose.yml`` file for details.

### Run the project

```
docker-compose up

TO-DO - currently both App and DB containers are up and running. It's inserting DB values on start but not able to access API from container. Need to check it.

mvn spring-boot:run - App can be accessed at http://localhost:8080
````

Containers for both services will be launched. The project can be reached at http://localhost:8000.

devtools / Hot-reloading is enabled (i.e. changes to the Java code in the project will cause the application to restart so that they 
can be used.)


## How to

### Run the local project on a different port

The container runs a Tomcat server listening on port 8080. The ``docker-compose.yml`` file is set up to
expose this port to the Docker host at port 8000, but you are free to change it as you wish - edit the ``ports`` directive:

```
services:
  web:
    [...]
    ports: 
      - 9090:8080
```

## Reading Product Config file (Spring Batch)-

Product config file is read on startup of Application using Spring Batch and it inserts value in to DB.

## Swagger API - 

Swagger can be accessed in following URL - http://localhost:8080/swagger-ui/index.html#/
![image](https://user-images.githubusercontent.com/29896984/205980826-facaf8cf-ae52-4404-8e43-63efe0bd29af.png)
![image](https://user-images.githubusercontent.com/29896984/205980964-898b71ce-2214-4fd6-a718-69ad21cc6bb6.png)

