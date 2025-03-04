# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Seed Database
FROM build AS seed
WORKDIR /app
CMD ["java", "-cp", "target/your-app.jar", "com.tecnologiaefinancas.library.config.SeedDatabase"]

# Stage 3: Run
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
