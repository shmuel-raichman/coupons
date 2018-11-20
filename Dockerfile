# B"H
# Debian Linux with OpenJDK JRE
FROM openjdk:8-jre-slim
# copy jar into image
RUN ls -la && pwd && find

ADD ./build/libs/final_project-0.0.1-SNAPSHOT.jar ./
# run application with this command line
CMD ["/usr/bin/java", "-jar", "/app.jar"]
