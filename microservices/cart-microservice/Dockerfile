FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache curl bash
WORKDIR /app

COPY microservices/cart-microservice/target/cart-microservice-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8093
ENTRYPOINT ["java", "-jar", "app.jar"]