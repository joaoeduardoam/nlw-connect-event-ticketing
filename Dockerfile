# Etapa 1: Compilação
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Execução
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/nlw-connect-event-ticketing-0.0.1-SNAPSHOT.jar nlw-connect-event-ticketing.jar
ENTRYPOINT ["java", "-jar", "/app/nlw-connect-event-ticketing.jar"]
