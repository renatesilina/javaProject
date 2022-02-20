# javaProject
Download the application folder
Option one:
Open project folder in code editor and run the main program

Option two:
Open a cmd and navigate to the application folder
Execute the following commands to run the aplication:
mvn package
java -jar target/mortageplan-1.0.1.jar


Build a Docker image from Dockerfile (included in program package)
CMD -> locate to program folder
Buid image:
docker build -t <container_id> .
ex:
docker build -t mortageplan/docker .
run image in cmd:
docker run -i mortageplan/docker
