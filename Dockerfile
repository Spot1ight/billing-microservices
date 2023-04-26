FROM maven:3.8.2-openjdk-11-slim AS builder
WORKDIR /app
COPY pom.xml .
COPY /eureka-server/pom.xml /app/eureka-server/pom.xml
COPY /eureka-server/src /app/eureka-server/src
WORKDIR /app/eureka-server/
RUN mvn clean install

FROM openjdk:11-jdk-slim
MAINTAINER Azamat Ayup <azamat.ayup@qaj.kz>
WORKDIR /app
COPY --from=builder /app/eureka-server/target/eureka-server.jar .
EXPOSE 8060
CMD ["java", "-jar", "eureka-server.jar"]

