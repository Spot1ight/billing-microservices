FROM openjdk:11-jdk-slim
EXPOSE 8060
COPY target/eureka-server.jar .
ENTRYPOINT ["java","-jar","eureka-server.jar"]