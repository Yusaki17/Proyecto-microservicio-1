FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache curl bash
WORKDIR /app

COPY api-gateway/target/api-gateway-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8222
ENTRYPOINT ["java", "-jar", "app.jar"]