FROM openjdk:17-jdk-alpine
LABEL authors="garfa"
EXPOSE 8761
ADD target/DiscoveryServer-0.0.1-SNAPSHOT.jar DiscoveryServer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/DiscoveryServer-0.0.1-SNAPSHOT.jar"]