# CS157A Final Project - Hospital Database

## How to get started
1. Open up a terminal of your choice and cd into your project folder.
2. `git clone https://github.com/Annabel1054/CS157A-Hospital-Project.git`
3. `cd CS157A-Hospital-Project`
4. `cd hospital`

## Running the application
### Prerequisites
- Sign up for an account on Docker Hub: [https://hub.docker.comLinks to an external site.](https://hub.docker.com/)
- Install Docker Desktop: https://www.docker.com/products/docker-desktop/ 
- Install SDK Man: https://sdkman.io/
- Install Java Open JDK 11: https://adoptium.net/ 
  - Make sure it is version 11.
  - You can use also use SDK Man to install Java.
- Install Maven 3.8 using SDK Man: https://sdkman.io/sdks#maven


### Steps
### Important Note: you must run your mysql container and create database before running the hospital container.
1. In your terminal, cd into `hospital` folder.
2. Create your own branch so you can modify the code: `git checkout -b <your branch name>`
3. Create a network if you haven't done so: `make create-hospital-network`
4. Run your mysql container: `make mysql`
5. Open up Docker Desktop
  - <img width="1369" alt="Screenshot 2023-05-12 at 8 27 40 PM" src="https://github.com/Annabel1054/CS157A-Hospital-Project/assets/55632013/3d41752b-2777-4eef-8aeb-caf0d84cd13c">
6. Click on "mysql" container and select the "Terminal" tab
  - <img width="1366" alt="Screenshot 2023-05-12 at 8 28 45 PM" src="https://github.com/Annabel1054/CS157A-Hospital-Project/assets/55632013/8de11b84-05fa-4477-8fb9-e51efed47697">
7. `mysql --password`, input "cs157a" to log into your mysql terminal.
  - <img width="1368" alt="Screenshot 2023-05-12 at 8 29 25 PM" src="https://github.com/Annabel1054/CS157A-Hospital-Project/assets/55632013/e91d836c-4829-46ad-8897-cda308e2def6">
8. `create database hospital;`
9. `use hospital;`
10. Once your database has changed to hospital, you can run any SQL commands on it.
  - Example: `show tables;`, `select * from <table name>;`
11. Run your hospital container: `make docker-run`, you need to wait around a minute before opening up the port.
  - <img width="1367" alt="Screenshot 2023-05-12 at 8 34 47 PM" src="https://github.com/Annabel1054/CS157A-Hospital-Project/assets/55632013/db54517e-1ac7-47ab-98c2-436edd8f6336">
  - Click on "8080:8080" to open up localhost.
  - Right now, we do not have anything mapped to the path "/" so you will get an error.
12. Run the hospital app, input link in your browser: http://localhost:8080/doctor
  - <img width="1470" alt="Screenshot 2023-05-12 at 8 37 23 PM" src="https://github.com/Annabel1054/CS157A-Hospital-Project/assets/55632013/5ac3360c-f844-4531-9238-91d7f43a76c6">

### Modifying Code
- Everytime you make modifications on the hospital app, you need to delete the hospital container from Docker Desktop.
- Rerun the container using: `make docker-run`


