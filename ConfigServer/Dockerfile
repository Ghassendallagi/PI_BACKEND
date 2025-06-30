FROM openjdk:17-jdk-alpine
LABEL authors="garfa"
EXPOSE 8888
ADD target/ConfigServer-0.0.1-SNAPSHOT.jar ConfigServer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ConfigServer-0.0.1-SNAPSHOT.jar"]