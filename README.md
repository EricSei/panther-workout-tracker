# Panther Workout Tracker
- Backend Rest API for Panther Workout Tracker

# Demo
- Demo Links 

# Features

# Architectural Diagram
- Lowlevel Design
  - Entity Relationships Design
 ![alt text](https://github.com/ericsei/panther-workout-tracker/blob/main/assets/data_model_diagram.png?raw=true)
- Highlevel Design
  - AWS 


# Technology Stack
Java, SpringBoot,  Spring Data JPA, MySQL

# Installing Local Environment
- clone the project
- setup credentials in application.properties
- update maven

# Database Installation

- create application.properties file at src/main/resources/application.properties
- and add the following content and update with Your Database Credentials

```
## if port 8080 is in use, can change our port number using the line below
##server.port=8090
#
## Mac/Linux info for MySQL login
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/<DB_NAME>?serverTimezone=EST5EDT
spring.datasource.username=<DB_USER_NAME>
spring.datasource.password=<DB_PASSWORD>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
#
##Windows info for MySQL login
##spring.jpa.hibernate.ddl-auto=update
##spring.datasource.url=jdbc:mysql://localhost:3306/new_workout_db
##spring.datasource.username=root
##spring.datasource.password=mysql@root
#
## Shows logs for the queries hibernate uses for our interactions with our database
#spring.jpa.show-sql=true
#spring.jpa.properties.hibernate.format_sql=true

```

# GitHub Branching Workflow
```

1 ) create branch and checkout to that branch
$ git checkout -b feature/<your-feature-name>
2 ) update with the currunt origin master
$ git pull origin master 
3 ) resolve coflict if you have them. (usually not the case). After your resolved,
$ git add .
4 ) make your changes, commit and push your remote branch
$ git add <filename>
$ git commit -m "commit name"
$ git push --set-upstream origin <feature/name>
5 ) go to github repo and open a pull request
6 ) let a teammeber review your code and approve it

```

# API Call Examples with JWT

```
Method : Post
URL : http://localhost:8080/api/authenticate 
Request Body
{
    "username" : "ryan",
    "password" : "ryan@123"
   
}

Response Body : 

{
    "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyeWFuIiwiZXhwIjoxNjg2NTU3NjExLCJpYXQiOjE2ODY1MjE2MTF9.11QG6CkjlPnUFYpbotFzHKSSY7snt3ChixFAS9oOsKs"
}

Set Autorization, Bearer Token

Token : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyeWFuIiwiZXhwIjoxNjg2NTU3NjExLCJpYXQiOjE2ODY1MjE2MTF9.11QG6CkjlPnUFYpbotFzHKSSY7snt3ChixFAS9oOsKs
http://localhost:8080/api/goals

Request Body: 

{
    
    "startDate": "2023-06-11",
    "endDate" : "2023-07-23",
    "goalNum": 12

}

Response Body:
{
    "id": 1,
    "startDate": "2023-06-11",
    "endDate": "2023-07-23",
    "goalNum": 12
}

```

# Coding Style Guide

https://google.github.io/styleguide/javaguide.html 

# Authors
- Eric Sei
- Gavin
- Jess
- Jesus
