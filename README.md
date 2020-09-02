# rrchallenge
 
Requirements to run:

1. Docker
2. IDE (I used IntelliJ IDEA)

Setup Steps
1. Once Docker is installed, run the following command

        docker run -p 3306:3306 --name class-mysql -e MYSQL_ROOT_PASSWORD=my_secret_password -e  MYSQL_DATABASE=classroom -d mysql:latest
 
 2. Import the project in your IDE, build and run.
 
 3. Go to http://localhost:8080/  in your browser
 
 
 
 Notes:
 
 1. Click on a row to open the edit user popup
 2. To add more users to the list, update the import.sql file by adding more import statements. Restart the application after this is completed.
 3. If you decide to use a different root password, then you will need to update the password in the application.properties file.