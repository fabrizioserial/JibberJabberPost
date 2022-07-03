#FROM gradle:7.4.1-jdk11
#COPY . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle build
#EXPOSE 8080
#LABEL org.opencontainers.image.source="https://github.com/fabrizioserial/JibberJabberPost"
#ENTRYPOINT ["java","-jar","/home/gradle/src/build/libs/jibberjabber-0.0.1-SNAPSHOT.jar"]

FROM gradle:7.3.3-jdk17-alpine AS build
COPY  . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle assemble

FROM openjdk:17-alpine
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=production","/app/spring-boot-application.jar"]