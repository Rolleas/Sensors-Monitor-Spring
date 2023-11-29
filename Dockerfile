FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/Sensors-Monitor-0.0.1-SNAPSHOT.jar Sensors-Monitor.jar

CMD ["java", "-jar", "Sensors-Monitor.jar"]
