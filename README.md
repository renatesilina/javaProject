# javaProject
How to run the project.
Download the application folder.

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
docker build -t <image_name> .

run image in cmd:
docker run -i <image_name>
