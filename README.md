# Candidate App
A small application that makes a report for you about several interview supervisors, itnerviewers and their sessions.

## The stack
The application consists of two main apps:

* a REST API, built with Spring Boot
* a web client, built with Angular

## How to run the app?
To run the app, make sure you have all the dependencies needed, and perform the commands below!

### Run the REST API
The REST API communicates with a Microsoft SQL server, so before you spin it up, make sure you have a running instance somewhere (on your computer or somewhere else).

You can configure the database connection with editing the `application.properties` file inside the project files of the REST API.

The project uses Maven to build itself, so make sure you have an installed version of it, the recommended is Maven 3!

If you have all the things above, run the following command inside the REST API's project directory:

```
mvn clean package spring-boot:run
```

The app is running on port 8080 by default.

### Run the client
The client is built with NodeJS, NPM and Angular, so make sure you have the NodeJS, NPM and Angular CLI installed on your machine!

After that, run the following commands inside the clients directory:
```
npm install
```

```
ng serve --open
```

The first command installs the projects dependencies, while the second command builds the project and starts to run it on port 4200 by default.

## The running app
The REST API has a main endpoint, which is at `/report/` . If you make a POST request on it, it will generate a report based on the data in the DB, and returns a response in JSON format. You can even send a `sessionStart` and a `sessionEnd` property in the request body, to ask only for sessions between these two datetime.

The client app runs on port 4200, and it makes a request to the endpoint below, then displays the data for the user. It also provides two datetime picker field to select the required range.