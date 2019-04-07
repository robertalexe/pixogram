FROM java:8-jdk-alpine

COPY ./target/pixogram-project-front-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch pixogram-project-front-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java", "-jar", "pixogram-project-front-0.0.1-SNAPSHOT.jar", "pixogramfront"]
