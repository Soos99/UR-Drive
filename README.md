# UR Drive

A local drive for UR students to store study resources in the university

## Supported features

1. Sign up, login, and log out (Authentication)
2. Add, download, and delete files in drive
3. Insert, view, and remove notes in drive
4. Store, reveal, and delete credentials in drive

## Technologies

- Spring MVC
- Thymeleaf
- Spring Security
- Hibernate
- MySQL
- Lombok

## Setup

1. Clone and import the project into your IDE 

   - Click on `pom.xml` when importing for Intellij

2. Add [Lombok](https://projectlombok.org/) to your IDE

3. Install [MySQL Community Server](https://dev.mysql.com/downloads/mysql/) in your machine

4. Setup database

   - Fill in your database server password `application.properties` file

   - Open MySQL CLI and create database urdrive:

     ```sh
     $ CREATE DATABASE urdrive;
     ```

5. (Optional) Running with terminal

   ```shell
   $ mvn clean build
   $ java -jar ./target/urdrive-0.0.1-SNAPSHOT.jar
   ```

## Contact

Feel free to contact [me](hle7@u.rochester.edu) with any questions, comments, suggestions, bug reports, etc...
