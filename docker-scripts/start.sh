#!/bin/bash
set -e
[[ -z "${PORT}" ]] && port=8080 || port="${PORT}"

      java -Djava.security.egd=file:/dev/./urandom -jar app.jar \
        --server.port="${port}" --spring.profiles.active=docker

  java -Djava.security.egd=file:/dev/./urandom -jar app.jar \
        --server.port="${port}" --spring.profiles.active=dockerreference

