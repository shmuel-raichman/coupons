# B"H
# Debian Linux with OpenJDK JRE
FROM openjdk:8-jre-slim
# copy jar into image
ADD /build/libs/final_project-0.0.1-SNAPSHOT.jar ./app.jar
RUN apt update && apt install -y vim
ENV MYSQL_CON "pring.datasource.url=jdbc:mysql://local:3306/coupons?useSSL=false&allowPublicKeyRetrieval=true"

EXPOSE 8080

# run application with this command line
CMD echo "35.243.170.169    local" >> /etc/hosts && java -jar /app.jar && /bin/bash