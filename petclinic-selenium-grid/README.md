Execute docker-compose on root folder
````sh
docker-compose up
````

Then execute docker-compose again
````sh
docker-compose up
````

Execute maven after selenium-grid up
````sh
mvn test
````

If you want to execute .side Selenium IDE project, go to petclinic-selenium-grid folder and build selenium-grid image
````sh
docker build -t selenium-runner .
````

Execute container of selenium-runner of nodejs
````sh
docker run -it --rm -v /home/joao/Sources/Test/selenium-spring-tests/petclinic-selenium-grid/script:/script selenium-runner selenium-side-runner --server http://172.17.0.1:4444/wd/hub /script/petclinic.side --base-url http://172.17.0.1:8080
````