FROM openjdk:8-jdk-alpine

COPY study-springboot/build/libs/study-springboot-1.0.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]