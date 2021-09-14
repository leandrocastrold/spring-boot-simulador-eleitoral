FROM openjdk
WORKDIR /app
EXPOSE 8080
COPY target/eleitoral-0.0.1-SNAPSHOT.jar /app/eleitoral-app.jar
ENTRYPOINT ["java", "-jar", "eleitoral-app.jar"]
