#Using Docker:
./mvnw install dockerfile:build

docker run -p 8080:8080 -t springio/cursomc:latest