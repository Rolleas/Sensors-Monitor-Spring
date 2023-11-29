#!/bin/bash

while IFS= read -r line; do
  export "$line"
done < .env

docker build -t sensor:1.0 .

docker run -p 8080:8080 -e DB_HOST="$DB_HOST" -e DB_PORT="$DB_PORT" -e DB_NAME="$DB_NAME" -e DB_USERNAME="$DB_USERNAME" -e DB_PASSWORD="$DB_PASSWORD" sensor:1.0

