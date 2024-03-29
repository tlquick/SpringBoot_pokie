
## Spring Boot_Pokie
A project that takes a small Java GUI enterprise application (from an existing BlueJ project) and creates a web app using Spring Boot and Thymeleaf in Eclipse
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Example Use](#example-use)
* [Live Site](#live-site)

## General Info
The aim of this project is to transform an enterprise application into a web app that can be deployed in a Docker container. <br>
This project will also include basic JUnit tests to ensure each iteration does not break the product. Thymeleaf will be used to make the front end. <br>
<b>Tasks to complete: </b><br>
Step 1: get existing models to compile and run in Springboot starter, write some unit tests in JUnit & rewrite for loops to streams - except where objects change or streams becomes overly complex<br>
Step 2: write the front end in thymeleaf <br>
Step 3: write tests for the controller in Mockito <br>
Step 4: create a docker container <br>
Step 5: deploy to cloud <br>
<br>
## Technologies
Spring Boot 3.0, Maven, Java 17, JUnit, H2 database with multiple tables, Hibernate and Docker Desktop <br>
<br>
POM dependancies: spring-boot-starter-parent, spring-boot-starter-web, spring-boot-starter-web-services, spring-boot-starter-thymeleaf, spring-boot-starter-test, junit-jupiter-api <br>

## Setup

Clone or fork the repo. Open Eclipse and import maven project. Run mvn clean install <br>
Run springboot locally and test on port 8080 eg 
```
http://localhost:8080/ 
```
Dockerfile has been added to deploy to any cloud provider. I used Render, connecting my repository to Render dashboard. <br >
Render uses the dockerfile to build the image and deploy automatically, everytime code is pushed to the repo. <br>
If you have Docker Desktop and a Docker Hub account, you can build your own image using:
```
mvn -f pom.xml install 
docker login
docker build -t <dockerHubUser>/springboot_pokie:<tag> .
docker run -p 8080:8080 <dockerHubUser>/springboot_pokie:<tag>
docker push <dockerHubUser>/springboot_pokie:<tag>

```
Or you can use mine from Docker Hub: tlquick/springboot_pokie:0.0.1-SNAPSHOT

## Example Use
The Pokie app loads, displaying the Pokie app on port 8080<br>
![PokieStart](/docs/pokie_load.jpg?raw=true "Home Page") <br>
The user adds credits, selects the number of lines and credits, then clicks Spin.
The web app randomly determines the result of the spin, calculating any payouts and updates the Player balance
![PokieRun](/docs/pokie_example.jpg?raw=true "Example") <br>. 

## Live Site
https://springboot-pokie.onrender.com <br>
