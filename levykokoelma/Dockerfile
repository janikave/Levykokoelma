FROM maven:3.8.6-eclipse-temurin-17-focal AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM eclipse-temurin:17-jre-focal
# StudentListSecureDB-0.0.1-SNAPSHOT.jar  = <artifactId>-<version>.jar (pom.xml)
COPY --from=build /home/app/target/levykokoelma-0.0.1-SNAPSHOT.jar /usr/local/lib/levykokoelma.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/levykokoelma.jar"]