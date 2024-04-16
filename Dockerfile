FROM openjdk:17-alpine
COPY build/libs/*.jar app.jar

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]