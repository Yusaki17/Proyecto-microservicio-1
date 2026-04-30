# Usa esta imagen para compilar (Tiene Maven 3.9 y Java 21)
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

WORKDIR /app
COPY . .

# Maven usará tu pom.xml para descargar Spring Boot 4.0.6
RUN mvn clean package -DskipTests -pl microservices/product-microservice -am

# Etapa de ejecución
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/microservices/product-microservice/target/*.jar app.jar

EXPOSE 8092
ENTRYPOINT ["java", "-jar", "app.jar"]
