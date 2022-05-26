# selenium grid up
docker-compose up

# Open browser port 4444

# build selenium runner
docker build -t selenium-runner .

# selenium-side-runner
docker run -it --rm -v /home/joao/Sources/Test/selenium-spring-tests/petclinic-selenium-grid/script:/script selenium-runner selenium-side-runner --server http://172.17.0.1:4444/wd/hub /script/petclinic.side --base-url http://172.17.0.1:8080

#JUnit RemoteWebDriver
mvn clean install test