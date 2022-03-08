FROM maven:3.8.4-jdk-8-slim
WORKDIR /app
COPY pom.xml ./
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package

FROM tomcat:9-jre8-temurin
COPY --from=0 /app/target/cinetflix.war /usr/local/tomcat/webapps/
EXPOSE 8080