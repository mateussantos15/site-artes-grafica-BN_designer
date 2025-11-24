# build stage (Java 21)
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY pom.xml .
RUN mvn -B -f pom.xml dependency:go-offline
COPY src ./src
RUN mvn -B -DskipTests package

# runtime stage (Java 21)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# instalar curl e nc (netcat) para healthchecks/wait-for
RUN apk add --no-cache curl busybox-extras

# copiar jar
COPY --from=build /workspace/target/*.jar app.jar

# copiar script wait-for-db (se você usar)
COPY wait-for-db.sh /app/wait-for-db.sh
RUN chmod +x /app/wait-for-db.sh

EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=docker

# Usar entrypoint que aguarda DB (se você optar por usar)
ENTRYPOINT ["/app/wait-for-db.sh", "db", "5432", "60"]
# se preferir não usar wait-for, altere para:
# ENTRYPOINT ["java","-jar","/app/app.jar"]
