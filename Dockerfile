FROM maven:3.8.5-amazoncorretto-17 as build


COPY pom.xml /usr/src/orthology-api/

RUN mvn -f /usr/src/orthology-api/pom.xml clean package -P test


# The final image should have a minimal number of layers
FROM amazoncorretto:17

VOLUME /tmp

COPY  --from=build /usr/src/orthology-api/target/*.jar app.jar
COPY docker-scripts/start.sh /

RUN adduser \
    --disabled-password \
    --gecos "" \
    --no-create-home \
    --uid 20256 \
    containeruser && \
    chown containeruser:containeruser app.jar && \
    chown containeruser:containeruser start.sh && \
    chmod +x /start.sh

ENTRYPOINT ["/start.sh"]
USER containeruser
