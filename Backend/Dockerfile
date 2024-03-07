FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar nutrichic-back.jar
ENTRYPOINT ["java","-jar","nutrichic-back.jar"]
EXPOSE 8080