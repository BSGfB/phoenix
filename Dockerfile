FROM openjdk:8-jdk-alpine
COPY ./rest/build/libs/ /target/
RUN mv $(find /target/ -name rest*.jar) /target/rest.jar
ENTRYPOINT ["java","-jar","/target/rest.jar"]
