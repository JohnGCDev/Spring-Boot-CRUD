# Spring-Boot-CRUD
A basic CRUD for a MySQL table called Laptops built with Spring Boot 2.5.3

## Needed Settings 📋

* Download/clone code and open it with STS4.0. Update maven dependencies. 
* [Lombook](https://projectlombok.org/setup/eclipse) library installed in your IDE (STS).
* You need a MySQL database called ```db_laptops``` and a user with all the grants.
* A datasource url for spring such as ```jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_laptops``` at [application.properties file](/src/main/resources/application.properties)
* Your user's username in ```spring.datasource.username field``` at [application.properties file](/src/main/resources/application.properties)
* Your user's password in ```spring.datasource.password field``` at [application.properties file](/src/main/resources/application.properties)
* An appropiate Hibernate dialect for your MariaDB/MySQL version in the field```spring.jpa.properties.hibernate.dialect``` at [application.properties file](/src/main/resources/application.properties)

## Execution 🚀

* Finally run the project as a Spring Boot App.
* You can use [Postman](https://www.postman.com/) to test the endpoints. Check out the [EverisEscuelaJava.postman_collection.json file](EverisEscuelaJava.postman_collection.json) for an example.


## Acknowledgments 🎁
* This project was inspired by [Antony Barranzuela](https://github.com/JoelBarranzuela) (Email: antony.joel.barranzuela.cuzcano@nttdata.com) and his a-week course: "Introducción a POO y Spring"
