FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY target/product-microservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "app.jar"]