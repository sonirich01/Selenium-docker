FROM openjdk:18-jdk-alpine3.15
RUN apk add curl jq
WORKDIR /usr/share/docker
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
ENV HUB_HOST=$HUB_HOST \
    MODULE=$MODULE \
    BROWSER=$BROWSER

ADD testng.xml testng.xml
ADD searchModule.xml searchModule.xml
ADD healthcheck.sh healthcheck.sh

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
    -DHUB_HOST=$HUB_HOST \
    org.testng.TestNG $MODULE
