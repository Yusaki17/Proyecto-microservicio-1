# Etapa 1: Compilación (Ya trae Maven y Java 21 integrados)
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

WORKDIR /app
COPY . .
# No necesitas instalar nada, solo compilar
RUN mvn clean package -DskipTests -pl microservices/cart-microservice -am

# Etapa 2: Ejecución (Tu imagen ligera de siempre)
FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache curl bash
WORKDIR /app

COPY --from=build /app/microservices/cart-microservice/target/*.jar app.jar

EXPOSE 8093
ENTRYPOINT ["java", "-jar", "app.jar"]
