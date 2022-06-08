#!/bin/bash
set -e
[[ -z "${PORT}" ]] && port=8080 || port="${PORT}"
echo "started qwewqewqewqewqeqwe"
if [ -z "${DOCKER_PRODUCTION}" ]; then
echo "first qwewqewqewqewqeqwe"
  if [ -z "${GENTAR_SCHEMA}" ]; then
echo "second qwewqewqewqewqeqwe"
    if [ -z "${EBI_PROXY}" ]; then
echo "thirdc qwewqewqewqewqeqwe"
      java -Djava.security.egd=file:/dev/./urandom -jar app.jar \
        --server.port="${port}" --spring.profiles.active=dockerreference

    fi

  fi

fi
