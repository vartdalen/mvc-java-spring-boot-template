#Dockerfile
# Start with a base image containing Java runtime
FROM adoptopenjdk:11-jre-hotspot

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8760

# The application's jar file
ARG JAR_FILE=target/template-0.0.1.war

# Add the application's jar to the container
ADD ${JAR_FILE} template-0.0.1.war

# Run the jar file
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/template-0.0.1.war"]