FROM maven:3.5.2-jdk-8 AS build
WORKDIR /app
COPY src src
COPY pom.xml pom.xml
RUN mvn -f pom.xml clean package
RUN mv target/pay-*.jar target/pay.jar

FROM openjdk:8
ARG GIT_SHA
ENV GIT_SHA=$GIT_SHA
ENV TINI_VERSION v0.19.0
RUN DEBIAN_FRONTEND="noninteractive" apt-get -y install tzdata
ENV TZ=Asia/Dhaka
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
WORKDIR /app
RUN curl -sSL https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini --output /usr/sbin/tini \
        && chmod +x /usr/sbin/tini
COPY --from=build /app/target/pay.jar pay.jar
EXPOSE 8080
ENTRYPOINT ["/usr/sbin/tini", "--"]
CMD ["java", "-jar", "pay.jar", "--spring.config=application.properties"]
