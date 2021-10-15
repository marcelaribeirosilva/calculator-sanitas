# Calculator Project for SANITAS

### Project Description

The goal of this exercise is to implement a "calculator" microservice, using maven + spring-boot.

This microservice has to expose an API that must be able, based on some input parameters, to perform arithmetic operations. Being a POC version, it will only be able to perform addition and subtraction of two elements, although it is anticipated that in future versions there will be other types of operations and of greater complexity. Also included with this statement is a jar that contains an operations tracing API that must be invoked by the microservice to trace the result of the operation.

### Project Instalation

1 - First we need to install de tracer lib by executing maven command: mvn install:install-file -Dfile=<PROJECT_ROOT_FOLDER>/lib/tracer-1.0.0.jar

2 - Now we can run our project executing maven command: mvn spring-boot:run

3 - Copy this URL to any web browser: http://localhost:8080/calculator/sum/5/4

	3.1 - To execute a subtraction you can use this URL: http://localhost:8080/calculator/subtraction/5/4

	3.2 - You can change the numbers and the web service will do the calculation! Have fun!