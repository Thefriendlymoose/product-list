FROM maven:3.9.6-eclipse-temurin-22 AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/

RUN mvn package

FROM eclipse-temurin:22-jre-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/backendtest-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "backendtest-0.0.1-SNAPSHOT.jar"]