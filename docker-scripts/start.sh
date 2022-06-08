#!/bin/bash
set -e
[[ -z "${PORT}" ]] && port=8080 || port="${PORT}"

if [ -z "${DOCKER_PRODUCTION}" ]; then

  if [ -z "${GENTAR_SCHEMA}" ]; then

    if [ -z "${EBI_PROXY}" ]; then

      java -Djava.security.egd=file:/dev/./urandom -jar app.jar \
        --server.port="${port}" --spring.profiles.active=dockerreference

    fi

  fi

fi
