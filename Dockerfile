#
# Build stage
#
FROM maven:3.9.2-eclipse-temurin-20-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:20
COPY --from=build /target/learning-spring-0.0.1-SNAPSHOT.jar learning-spring.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","learning-spring.jar"]