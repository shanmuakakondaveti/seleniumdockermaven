FROM openjdk:8-jre-slim

WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
ADD  target/seleniumdockermaven212.jar seleniumdockermaven212-1.jar
ADD  target/seleniumdockermaven212-tests.jar seleniumdockermaven212-tests.jar
ADD  target/libs libs

# Add the suite xmls
ADD testng.xml testng.xml

# Command line to execute the test
# Expects below ennvironment variables
# BROWSER = chrome / firefox
# MODULE  = order-module / search-module
# GRIDHOST = selenium hub hostname / ipaddress

ENTRYPOINT java -cp seleniumdockermaven212.jar:seleniumdockermaven212-tests.jar:libs/* -DseleniumHubHost=selenium-hub -Dbrowser=chrome org.testng.TestNG testng.xml