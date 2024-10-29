FROM openjdk:11.0.14.1-jre

COPY ./build/libs/*.jar application.jar

ENTRYPOINT ["java", "-jar", "/application.jar"]