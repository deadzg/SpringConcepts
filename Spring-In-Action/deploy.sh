#!/bin/bash

echo "Stopping Container"
sh /Users/soumalwe/Work/apache-tomcat-8.5.5/bin/shutdown.sh
echo "Building project"
gradle clean build
rm -rf /Users/soumalwe/Work/apache-tomcat-8.5.5/webapps/Spring-In-Action
echo "Copying the war"
cp build/libs/Spring-In-Action.war /Users/soumalwe/Work/apache-tomcat-8.5.5/webapps/
echo "Deploying the project.."
sh /Users/soumalwe/Work/apache-tomcat-8.5.5/bin/startup.sh
