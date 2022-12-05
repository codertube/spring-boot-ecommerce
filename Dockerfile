FROM openjdk:17-alpine
EXPOSE 8080
ADD target/spring-boot-ecommerce.jar spring-boot-ecommerce.jar
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.7.3/wait /wait
RUN chmod +x /wait
ENTRYPOINT ["java", "-jar", "spring-boot-ecommerce.jar"]