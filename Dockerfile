FROM gradle:7.4.1-jdk11
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/gradle/src/build/libs/jibberjabber-0.0.1-SNAPSHOT.jar"]