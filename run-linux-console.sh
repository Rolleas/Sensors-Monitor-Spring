#!/bin/bash

while IFS= read -r line; do
  export "$line"
done < .env

java -jar target/Sensors-Monitor-0.0.1-SNAPSHOT.jar
