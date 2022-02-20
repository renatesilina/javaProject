
# Base image
FROM maven:3.8.4-jdk-11
# Set images working directory
WORKDIR /app

# Copy files to image
COPY .mvn/ .mvn
COPY pom.xml ./
# Install mvn dependencies
RUN mvn dependency:go-offline -B

# Copy source code to image
COPY src ./src
RUN mvn package
# Command to run when image is executed
CMD ["java", "-jar","target/mortageplan-1.0.1.jar"]