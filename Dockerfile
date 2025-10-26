# ---- Build stage ----
    FROM maven:3.9-eclipse-temurin-17 AS build
    WORKDIR /workspace
    COPY pom.xml .
    RUN mvn -q -DskipTests dependency:go-offline
    COPY src ./src
    RUN mvn -q -DskipTests package
    
    # ---- Run stage ----
    FROM eclipse-temurin:17-jre
    WORKDIR /app
    COPY --from=build /workspace/target/*.jar app.jar
    EXPOSE 8080
    CMD ["sh", "-c", "java -jar app.jar"]
    