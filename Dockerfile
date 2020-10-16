FROM gradle:latest AS Builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:11
COPY --from=Builder /home/gradle/src/build/libs/*.jar /apps/search-api/search-api.jar
EXPOSE 8080
CMD ["java","-jar","--illegal-access=warn","/apps/search-api/search-api.jar"]