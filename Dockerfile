FROM ubuntu

RUN apt update
RUN apt-get install -y curl wget maven  openjdk-17-jdk openjdk-17-jre

RUN mkdir /app
ADD src/ /app
ADD pom.xml /app
WORKDIR /app
# RUN mvn package
COPY /target/demo_001-0.0.1-SNAPSHOT.jar /app/


EXPOSE 8080

## RUN cp demo_001-0.0.1-SNAPSHOT.jar /app/api_001.jar

CMD ["java", "-jar", "/app/demo_001-0.0.1-SNAPSHOT.jar"]
