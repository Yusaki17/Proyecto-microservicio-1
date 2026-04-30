# ETAPA 1: Compilación (Ya tiene Maven y JDK 21)
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

WORKDIR /app

# No instalamos nada con apk aquí para evitar que se cuele Java 25
COPY . .
RUN mvn clean package -DskipTests -pl api-gateway -am

# ETAPA 2: Ejecución (Imagen ligera con JRE 21)
FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache curl bash
WORKDIR /app

# Copiamos el archivo generado en la etapa anterior
COPY --from=build /app/api-gateway/target/*.jar app.jar

# Puerto configurado para tu Gateway
EXPOSE 8222

ENTRYPOINT ["java", "-jar", "app.jar"]
