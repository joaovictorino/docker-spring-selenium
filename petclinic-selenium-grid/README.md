## How to execute Selenium Grid and JUnit or Selenium Runner

Execute docker-compose on root folder to initialize application
````sh
docker-compose up
````

Then execute docker-compose again on petclinic-selenium-grid to initialize Selenium Grid
````sh
docker-compose up
````

After application and Selenium Grid is up, execute Maven test
````sh
mvn test
````

If you want to execute .side, Selenium IDE project, go to petclinic-selenium-grid folder and build selenium-grid image
````sh
docker build -t selenium-runner .
````

Execute container of Selenium Runner of Node, change de ip address of your host and the script's path inside the project
````sh
docker run -it --rm -v /home/joao/Sources/Test/selenium-spring-tests/petclinic-selenium-grid/script:/script selenium-runner selenium-side-runner --server http://172.17.0.1:4444/wd/hub /script/petclinic.side --base-url http://172.17.0.1:8080
````