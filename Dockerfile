FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/ItemMS.jar
COPY ${JAR_FILE} ItemMS.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/ItemMS.jar"]