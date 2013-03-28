**Downloading / Installing Maven**

http://maven.apache.org/download.cgi

**Downloading / Installing MySQL**

1. Download MySQL: http://dev.mysql.com/downloads/mysql/
2. Install/Setup MySQL: http://dev.mysql.com/tech-resources/articles/mysql_intro.html
3. Import data file: mysql -u username -p example < /src/main/resources/example.sql
4. Set database properties /src/main/resources/config/default.properties

****

**Building with Maven**

mvn clean install

**Running with Maven Jetty Plugin**

mvn jetty:run

**Running with Maven Jetty Plugin in a specific mode**

mvn jetty:run -Dapp.mode={mode} (e.g. mvn jetty:run -Dapp.mode=development)

**Check if it's running**

http://localhost:8080/

http://localhost:8080/home.json

