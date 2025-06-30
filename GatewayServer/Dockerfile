FROM openjdk:17-jdk-alpine
LABEL authors="garfa"
EXPOSE 8090
ADD target/GatewayServer-0.0.1-SNAPSHOT.jar GatewayServer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/GatewayServer-0.0.1-SNAPSHOT.jar"]
