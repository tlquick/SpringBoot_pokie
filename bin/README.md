
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
Step 1: get existing models to compile and run in Springboot starter, write some unit tests in JUnit & rewrite for loops to streams - except where objects change<br>
Step 2: write the front end in thymeleaf <br>
Step 3: create a docker container <br>
Step 4: deploy to cloud <br>
<br>
## Technologies
Spring Boot 3.0, Maven, Java 17, JUnit, H2 database with multiple tables, Hibernate and Docker Desktop <br>
<br>
POM dependancies: spring-boot-starter-parent, spring-boot-starter-web, spring-boot-starter-web-services, spring-boot-starter-thymeleaf, spring-boot-starter-test, junit-jupiter-api <br>
## Setup
Docker Desktop needs to be installed on the target environment.  <br>
Clone or fork the repo. Open Eclipse and import maven project. Run mvn clean install <br>

## Example Use
The Pokie app loads, displaying the Pokie app on port 8080<br>
![PokieStart](/docs/pokie_load.jpg?raw=true "Home Page") <br>
The user adds credits, selects the number of lines and credits, then clicks Spin.
The web app randomly determines the result of the spin, calcuating any payouts and updates the Player balance
![PokieRun](/docs/pokie_example.jpg?raw=true "Example") <br>. 
## Live Site
TBD<br>
