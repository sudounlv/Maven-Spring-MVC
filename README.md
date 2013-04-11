**Downloading / Installing Maven**

http://maven.apache.org/download.cgi

**Downloading / Installing Git**

http://git-scm.com/downloads


**Downloading / Installing MySQL**

1. Download MySQL: http://dev.mysql.com/downloads/mysql/
2. Install/Setup MySQL: http://dev.mysql.com/tech-resources/articles/mysql_intro.html

Alternatively, you can download <a href="http://www.apachefriends.org/en/xampp.html">XAMPP</a>, an Apache distribution that includes MySQL, PHP and Perl.  We will only be using MySQL for our purposes, but this is a much faster/easier way to get it up and going.

**Importing Data / Configuration**

1. Using your favorite SQL client, create a database called "example", then run the example sql script included at /src/main/resources/example.sql.  If you would prefer to do this from the command line, you can run the following command after you have created your "example" database: mysql -u username -p example < /**path-to-project**/src/main/resources/example.sql
2. Modify your database properties in /src/main/resources/config/default.properties

****

**To build and run the application, type the following commands from the base directory of the project:** 

***Building with Maven***

mvn clean install

***Running with Maven Jetty Plugin***

mvn jetty:run

***Running with Maven Jetty Plugin in a specific mode***

mvn jetty:run -Dapp.mode={mode} (e.g. mvn jetty:run -Dapp.mode=dev)

****

**Use the following URLs to see if your project is working:**

***Home Controller***

http://localhost:8080/

http://localhost:8080/home.json

***Test Product Controller***

http://localhost:8080/test/product

