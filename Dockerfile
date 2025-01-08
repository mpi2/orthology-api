FROM maven:3-amazoncorretto-21 as build

COPY pom.xml /usr/src/orthology-api/


COPY src /usr/src/orthology-api/src


RUN mvn -f /usr/src/orthology-api/pom.xml clean package


# The final image should have a minimal number of layers
FROM amazoncorretto:21

VOLUME /tmp

COPY  --from=build /usr/src/orthology-api/target/*.jar app.jar
COPY docker-scripts/start.sh /
COPY docker-scripts/wait-for-db.sh /

RUN chmod +x /start.sh && chmod +x /wait-for-db.sh


ENTRYPOINT ["/start.sh"]

