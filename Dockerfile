FROM openjdk:17-alpine
COPY build/libs/*.jar app.jar

ARG JASYPT_KEY

ENTRYPOINT ["java", "-jar", "app.jar", "--jasypt.encryptor.password=$JASYPT_KEY"]