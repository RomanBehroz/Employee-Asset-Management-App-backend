# define base docker image
FROM openjdk:18
LABEL maintainer="Roman Behroz"
EXPOSE 8080
ADD target/Employee-Asset-Management-0.0.1-SNAPSHOT.jar employee-asset-management.jar
ENTRYPOINT ["java", "-jar","employee-asset-management.jar"]