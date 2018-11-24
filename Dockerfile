# B"H
# Debian Linux with OpenJDK JRE
FROM openjdk:8-jre-slim
# copy jar into image
ADD /build/libs/final_project-0.0.1-SNAPSHOT.jar ./app.jar
RUN apt update && apt install -y vim
RUN echo "35.232.242.181	local" >> /etc/hosts
#ADD /src/main/resources/application.properties ./
# run application with this command line
EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]
#CMD /bin/bash