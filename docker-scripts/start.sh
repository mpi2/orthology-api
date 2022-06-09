#!/bin/ash
set -e
[[ -z "${TRACKER_PORT}" ]] && port=8080 || port="${TRACKER_PORT}"

if [ -z "${DOCKER_PRODUCTION}" ]; then

    if [ -z "${EBI_PROXY}" ]; then

      java -Djava.security.egd=file:/dev/./urandom -jar app.jar \
        --server.port="${port}" --spring.profiles.active=docker

    fi

else

  if [ -z "${EBI_PROXY}" ]; then

    java -Djava.security.egd=file:/dev/./urandom -jar app.jar \
      --server.port="${port}" --spring.profiles.active=dockerreference

  fi

fi
