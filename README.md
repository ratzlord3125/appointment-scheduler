
# Appointment Scheduler

This is an application to manage and schedule appointments inside a university. It is made using Spring Boot for Backend, MySQL for database management, and Thymleaf for frontend.


## Steps to Setup

**Create MySQL database**

```bash
create database appointmentscheduler
```

- After that run MySQL script to create tables `src/main/resources/appointmentscheduler.sql`

**Configure enviroment variables**

+ open `src/main/resources/application.properties`
+ set env variables for JDBC `datasource.url`, `datasource.username`, `datasource.password`
+ (optional) set env variables for mail server  `mail.username`, `mail.password`
+ set jwtSecret, encoded with Base64 `jwtSecret`
+ (optional) set localhost port in `base.url`

**Run the app using maven**

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080> (assumning default port).

**Login to default accounts**

A few accounts of each type are created by default when creating the database using `appointmentscheduler.sql`. You can check the username and password in this sql file.

**Appointment booking process**

To book a new appointment customer needs to click `New Appointment` button on all appointments page and then fill out the details.

> Not all features currently work. This project was inspired by [slabiak's AppointmentScheduler](https://github.com/slabiak/AppointmentScheduler).

