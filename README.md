# company-assignment
The purpose of this project is to create a Rest API that fetches the next available number based on a category code, following certain rules such as ensuring the sum of the individual digits is 1 and introducing a delay in processing. The API must be able to handle multiple concurrent requests and ensure that the outcome is unique. The project also aims to incorporate important non-functional features such as data persistence in a database, unit testing, and Git usage for version control. The ultimate goal is to demonstrate the ability to develop a robust and reliable API using Java and Spring Boot, while following best practices in software development.


# Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman


# Installation & Run
 - if you want to run the API server, you should have to update the database configuration inside the application.properties file and Update the port number, username and password as per your local database configuration.


```
    server.port=8088

    spring.datasource.url=jdbc:mysql://localhost:3306/yebelo;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```
https://localhost:8080/
```

