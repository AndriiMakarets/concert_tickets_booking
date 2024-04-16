# Use an official OpenJDK runtime as a base image
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built executable JAR from the target directory to the working directory
COPY out/artifacts/payment_service_jar/payment-service.jar /app/payment-service.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "payment-service.jar"]
