# Connecting to NBP API

## Description

This project is a RESTful application that connects to the API of the National Bank of Poland (NBP) to retrieve current currency exchange rates and display them. The application also stores logs of actions performed within the application in a database. Whenever an endpoint is executed, a sequence of events (logs) will be saved, indicating the specific change and the method through which it was executed.

## Running the Application
1. Build the JAR file by executing the following command:

```shell
./mvnw clean package -DskipTests
```

2. Run the application using Docker Compose: 

```shell
docker-compose up
```

## Swagger Documentation
To explore the available endpoints and interact with the API, you can use the Swagger UI. Once the application is running, you can access the Swagger UI using the following link: 
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/
