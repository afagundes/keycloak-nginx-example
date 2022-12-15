#!/bin/bash

# Use this script to export a Keycloak configuration.
# Exported file will be saved at nava-alma_licence-server/keycloak/config/realm-config.json.
#
# The database Keycloak uses must be up and running.
#
# Usage: ./export-keycloak-config.sh

KC_EXPORT_FILE_NAME=realm-config.json
KC_FINAL_DIRECTORY=./config

msg() {
     echo -e "#$(date +%F-%H-%M-%S.%N) SHELL: $*\n"
}

msg "Starting a Keycloak container to proceed with the realm export..."
docker run \
    -e KC_DB=mariadb \
    -e KC_DB_URL_HOST=nginx-database \
    -e KC_DB_URL_PORT=3306 \
    -e KC_DB_SCHEMA=keycloak \
    -e KC_DB_USERNAME=keycloak \
    -e KC_DB_PASSWORD=keycloakpwd \
    --network keycloak-nginx-proxy_default \
    nginx-keycloak-service:latest \
    export --file /tmp/${KC_EXPORT_FILE_NAME} --realm keycloak-nginx-test

printf "\n"

msg "Extracting exported file to ${KC_FINAL_DIRECTORY}/${KC_EXPORT_FILE_NAME}"
docker cp "$(docker ps -alq):/tmp/${KC_EXPORT_FILE_NAME}" ${KC_FINAL_DIRECTORY}

msg "Deleting Keycloak container"
docker container rm "$(docker ps -alq)"
