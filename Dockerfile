FROM openjdk:17.0.2-jdk as build
RUN mkdir /home/src
COPY ./ /home/app/
WORKDIR /home/app
RUN ./gradlew build

#Final run image
FROM openjdk:17.0.2
RUN mkdir /home/app
WORKDIR /home/app
COPY --from=build /home/app/build/libs/*.jar ./app.jar
CMD ["java","-jar","app.jar"]