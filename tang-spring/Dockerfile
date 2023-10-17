FROM registry.access.redhat.com/ubi8

WORKDIR /data

RUN yum install --disableplugin=subscription-manager --setopt=tsflags=nodocs java-17-openjdk -y && \
    yum clean all && \
    useradd -u 1000 -U app && \
    chown -R app:app /data

USER app
# Set the working directory within the container

# Copy the Spring Boot application JAR file into the container
COPY ./build/libs/tang-spring-0.0.1.jar /data/app.jar

# Expose the port on which your Spring Boot application runs (if applicable)
EXPOSE 8080

# Define the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
# CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=ysuspend=n,address=*5005","-jar","app.jar"]
# CMD ["java", "-Xmx2048m", "-XX:MaxMetaspaceSize=256m",  "-javaagent:dd-java-agent.jar",  "-jar", "api-service-0.0.1.jar"]
