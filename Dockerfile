FROM openjdk:17
ADD target/recruitment-task-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar","recruitment-task-0.0.1-SNAPSHOT.jar"]