# FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu
# RUN addgroup -S spring && adduser -S spring -G spring
# USER spring:spring
FROM mcr.microsoft.com/openjdk/jdk:17-distroless
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]