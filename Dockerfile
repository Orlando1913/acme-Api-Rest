FROM ubuntu:latest
LABEL authors="Orlando"

ENTRYPOINT ["top", "-b"]
# Usa una imagen base de AdoptOpenJDK17
FROM adoptopenjdk:17-jre-hotspot

WORKDIR /app

COPY target/acme-Api-Rest.jar acme-Api-Rest.jar

EXPOSE 8081

CMD ["java", "-jar", "acme-Api-Rest.jar"]