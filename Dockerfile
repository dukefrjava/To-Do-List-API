FROM ubuntu:24.04 AS build

RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven

WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]