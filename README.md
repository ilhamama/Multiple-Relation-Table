# Multiple-Relation-Table
---
This project shows workaround to achieve multiple tables having relation to single table with single "foreign key" column in Spring Boot. Instead utilize foreign key in database, this approach utilize Spring JPA and class inheritance.

## Run project in local machine

1) Create Database with name **db_multiple_relation** in Postgresql.
2) Run project with your IDE. or run `mvn spring-boot:run`.
3) Hit API `http://localhost:8080/data/user` or `http://localhost:8080/data/user?id=USR-TEST-00001`
