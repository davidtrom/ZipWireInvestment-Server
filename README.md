# ZipWire
## Account-Management Micro Web Application - Server

Follow the following instructions to successfully run this application on your local machine!

# Cloning This Repository

- Navigate your browser to https://github.com/deltaGPhys/FinanceApp
- Click the green "Clone or Download" button and copy github web URL or password protected SSH key.
- Open the command line interface.
- Navigate to the folder on your computer you would like to place the repository.
- Type "git clone" and then paste the repository url or SSH key. 
- Navigate into project repository to confirm clone was successful.

__________________________________________

# Building Spring Boot Project with Maven

To be able to run your Spring Boot app you will need to first build it. To build and package a Spring Boot app into a single executable Jar file with a Maven, use the below command. You will need to run it from the project folder which contains the pom.xml file.

<<<<<<< HEAD
    $ maven package

or you can also use

    $ mvn install
=======
    maven package

or you can also use

    mvn install
>>>>>>> dev

__________________________________________


# Running Application After Building


### Run Spring Boot app using Maven

You can also use Maven plugin to run your Spring Boot app. Use the below example to run your Spring Boot app with Maven plugin:

<<<<<<< HEAD
    $ mvn spring-boot:run
=======
    mvn spring-boot:run
>>>>>>> dev


### Run Spring Boot app with java -jar command

To run your Spring Boot app from a command line in a Terminal window you can you the java -jar command. This is provided your Spring Boot app was packaged as an executable jar file.

<<<<<<< HEAD
    $ java -jar target/mywebserviceapp-0.0.1-SNAPSHOT.jar
=======
    java -jar target/mywebserviceapp-0.0.1-SNAPSHOT.jar
>>>>>>> dev


### Run Spring Boot App with Gradle

And if you use Gradle you can run the Spring Boot app with the following command:

<<<<<<< HEAD
    $ gradle bootRun
=======
    gradle bootRun
>>>>>>> dev

Thank you for reading!


