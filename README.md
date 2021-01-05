- a Kotlin-based project with Spring Boot- using JDBC, MySQL dependencies.
- the DataSource and connection pool are configured in the application.properties

Here are the details of application.properties:
# Database Configuration

spring.datasource.url=jdbc:mysql://localhost:3306/users_schema
spring.datasource.username=tutorial
spring.datasource.password=123

On my system, the MySQl details are:
Host -- localhost                                    // the host URL
Port -- 3306                                         // the host POST number
Username -- Tutorial                                     // the username of the database
Password -- 123                                // the password of the database
Database Name - users                      // the Database name
Database Schema Name - users_schema        // the Database Schema name