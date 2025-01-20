# Build Stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime Stage
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Nakshe-1-0.0.1-SNAPSHOT.jar Nakshe.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Nakshe.jar"]
