FROM alpine:edge
MAINTAINER danoff
RUN apk add --no-cache openjdk8
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]