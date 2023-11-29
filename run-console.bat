@echo off

for /f "tokens=*" %%a in ('type .env') do @set %%a

java -jar target/Sensors-Monitor-0.0.1-SNAPSHOT.jar
PAUSE