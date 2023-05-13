all: clean

clean:
	mvn clean

compile:
	mvn compile

run: compile
	mvn spring-boot:run

run-jar: build
	java -jar target/hospital-1.0.jar

# Docker

build: 
	mvn package

docker-build: build
	docker build --platform=linux/amd64 -t hospital .
	docker images

docker-run: docker-build
	docker run --platform=linux/amd64 --network hospital -e "MYSQL_HOST=mysql" --name hospital -td -p 8080:8080 hospital

create-hospital-network:
	docker network create --driver bridge hospital

# MySQL DB

mysql:
	docker run --platform=linux/amd64 -d --network hospital --name mysql -td -p 3306:3306 -e MYSQL_ROOT_PASSWORD=cs157a mysql:8.0

mysql-shell:
	docker exec -it mysql bash

# Commands to run in mysql container's terminal
# `mysql --passowrd`
# input: cs157a
# `create database hospital;`
# `use hospital;`
# `show tables;`