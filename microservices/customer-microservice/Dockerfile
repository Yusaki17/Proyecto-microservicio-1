# Etapa 1: Compilación (Ya incluye Maven y JDK 21, no necesitas instalar nada)
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

WORKDIR /app
COPY . .

# Compila el microservicio específico
RUN mvn clean package -DskipTests -pl microservices/customer-microservice -am

# Etapa 2: Ejecución (Imagen ligera con JRE 21)
FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache curl bash
WORKDIR /app

# Copiamos el jar generado
COPY --from=build /app/microservices/customer-microservice/target/*.jar app.jar

# Puerto del Customer Microservice
EXPOSE 8091

ENTRYPOINT ["java", "-jar", "app.jar"]
