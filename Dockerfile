# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/calc-0.0.1-SNAPSHOT.jar calc.jar

# Expose port 1322 to the outside world
EXPOSE 1322

# Run the JAR file
ENTRYPOINT ["java", "-jar", "calc.jar"]
