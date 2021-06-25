# Car_Automobile
Purpose of my case Study

1. The purpose of this case study is to present a detailed description 
   of the Automobile system for companies that have different cars.
2. To display online  available cars. Customer can use Application to
   view different types of available cars
3. To create a convenient and easy to use application for staffs and 
   customers who want a good deal.
4. Customer Profile name, address, email, phone number. This information
   may be used to save items that have been viewed.
5. To explain the purpose and features of the system interfaces and what
   the system will do.

Document Conventions
1. Database(MariaDB)
2. Core Java
3. HTML5/CSS
4. Spring MVC
5. Junit Test

Project Name: Car Automobile

I created spring MVC with a dynamic application, named Car_Automobile.  I generate the web.xml file, and I converted it into a maven project.
I added some dependencies to the pom.xml.
I created a package in the src folder and named it  com.automobile.controller.
And I have some packages for each of the classes such as,
	- Model package
	- Database connection package
        - Dao package
	- Service package
	- Controller package
	- Customer Dao Test package
For model package,  I have java class with annotation entity, each class has Id and generated annotation  with some information.
For database connection, I have entity Manager Factory and entity manager.
For Dao package  I have interface that described CRUD methods and I used Java class that extends database connection and implements interface.
For service package, I have service annotation  with Autowired annotation
For the controller package, I have a class with controller annotation each class has path and handler method like POST and GET Mapping with Autowired. 
For Customer Dao Test package, I have all the CRUD tested with Junit Jupiter
I created the spring bean configuration file inside the “WEB-INF” folder and named it “dispatcher-servlet-xml”
I created a folder inside the “WEB-INF” and named it  views. Inside the views folder I have some JSP files.
I created a folder inside the “META-INF” and named it resources. Inside the resources folder I have images folder, styles folder.
In my WEBAPP I have fileuploads folder.


User Stories for my project

1. As a user I want to signIn and signUp
2. As a user I want to register  as a customer
3. As a user I want to select different type of car
4. As a developer I want to create an interface(UI) for customer
5. As a developer I want to create Spring mvc project(backend)
6. As a developer I want to create database(mariadb)
7. As a developer I want to test my code with Junit5

My challenge during this project

1. I have challenges on how to write authorization on login page, during the process I used,
   if else statement to generate true or false and was a little difficult to redirect.
2. When I tried to link some of my JSP files to another form, for example when I use 
    <a href=“home”>home</a> on signup page I have an error that says unable to see home.jsp . 
   I deleted the link for the purpose of my presentation today .
3. I have some challenges organizing my codes across different controllers.

