- a simple Kotlin-based project with Spring Boot- using JDBC, MySQL dependencies.
REST API 
- GET http://localhost:8082/users
- GET http://localhost:8082/users/{id}
- POST http://localhost:8082/users/new
- PUT http://localhost:8082/users/{id}
- DELETE http://localhost:8082/users/{id}

# Database Configuration
- the DataSource and connection pool are configured in the application.properties


On my system, the MySQl details are:
Host -- localhost                             // the host URL
Port -- 3306                                 // the host POST number
Username -- root                            // the username of the database
Password --  --                              // the password of the database
Database Name - users                      // the Database name
