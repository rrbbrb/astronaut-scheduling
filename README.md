# astronaut-scheduling

This part of the project is an attempt to build a scheduler for astronaut's tasks in participation of the NASA Space Challenge 2020.

## Prerequisites
- Java 13
- Angular 9
- Maven
- MySQL Database

## To run the application
This project has a separate frontend and backend.

#### Backend
Import `scheduler-backend` as a maven application to your IDE.

You will need to create a MySQL database and change the credentials in `scheduler-backend/src/main/resources/application.properties`. 
Run the application at `scheduler-backend/src/main/java/org/ntutsmartmedicalcloud/schedulerbackend/SchedulerBackendApplication.java`.

#### Frontend
After importing the `scheduler` folder to your IDE, install all the dependencies and run the application:
```
npm install
ng serve --open
```
Due to limited time given in this hackathon, we were unable to build the whole full-stack demonstration. But please feel free to test around on the backend.


