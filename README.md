# 0 Intro

We’re looking for code that is clean, readable, and maintainable. 

If you have any questions feel free to contact us via robert.hibbeler@time-matters.com or benedikt.koch@time-matters.com.

We prefer spring and gradle as this is our most used technology, but if you feel more comfortable using other frameworks or build-tools go for it!

# Part 1 - Holiday Service

For cost and price calculation we need to know if an order is processed on a public holiday. Until now this was handled in every project and implemented in a different way. To make it easier to administrate and use the data in future projects we decided to implement this in a single holiday service.

Our IT Solution Engineers created an API Definition which should be used as a reference. You can also find the OpenApi Spec as json or as yaml in `./api-contract/`

https://api.time-matters.com/api-editing/sharing/84ee67d6-e68b-49a2-9649-b4cbcc584782 

Please implement a working prototype. We don't care if the dates are real holidays, any example data will do. You do not need to conern yourself with data adminstration.

# Part 2 - DateDiff

We need an Service with an Endpoint that that accepts two dates with timezones in the following format: `CCYY-MM-DDThh:mm:ss[Z|(+|-)hh:mm]` and returns the difference between those two dates in hours. You can either add it to the Holiday Service or implement it as a standalone version.


# Part 3 - My Solution

The services of this application performs retrieving Public Holidays and calculating time difference between given two dates.

## Requirements

For building and running the application you need:

- Java 11 
- Maven 3

## Configurations
Database configurations and time format can be found in the application.properties file under the resources folder.

## Building the application
``` 
mvn clean install
``` 

## Running the application locally
One way is to execute the main method in the com.burak.holiday.kata.HlidayKataApplication class from your IDE. Alternatively you can use the Spring Boot Maven plugin like so:
``` 
mvn spring-boot:run
``` 

This will start the application with embedded H2 database and [Swagger UI](http://localhost:8080/swagger-ui/). It will be listening 8080 port.


The application will be started with initial data which can be used for testing endpoints. 
For public holiday endpoint you can use:
``` 
year: 2021, country code: DE
year: 2021, country code: TR
``` 
