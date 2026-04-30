# Etapa 1: Compilación con Maven y Java 21 integrados
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

WORKDIR /app
COPY . .

# Compila el discovery-server
RUN mvn clean package -DskipTests -pl discovery-server -am

# Etapa 2: Runtime ligero
FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache curl bash
WORKDIR /app

COPY --from=build /app/discovery-server/target/*.jar app.jar

# El puerto 8761 es el correcto para Eureka
EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]
