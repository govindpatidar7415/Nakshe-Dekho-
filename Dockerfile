FROM maven:3.8.3-openjdk-17
COPY . .
RUN  mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Nakshe-1-0.0.1-SNAPSHOT.jar Nakshe.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "Nakshe.jar" ]
