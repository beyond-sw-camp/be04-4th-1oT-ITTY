FROM openjdk:17-alpine
COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar", "--jasypt.encryptor.password=itty"]