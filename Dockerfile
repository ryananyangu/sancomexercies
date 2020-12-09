FROM openjdk:1.8

MAINTAINER Ryan Anyangu <ryananyangu@gmail.com>

RUN mkdir -p /app

WORKDIR /app

ADD ./target/*.jar ./target/

RUN chmod 755 -R ./target/*.jar

ARG SECRET


ENV SECRET=${SECRET}

ENTRYPOINT ["java","-jar","target/interview-0.0.1-SNAPSHOT.jar"]