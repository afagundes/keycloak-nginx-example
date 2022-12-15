FROM quay.io/keycloak/keycloak:20.0.1

RUN mkdir -p "/opt/keycloak/data/import"
ADD config/realm-config.json /opt/keycloak/data/import/

RUN /opt/keycloak/bin/kc.sh build --db=mariadb --http-relative-path /auth

EXPOSE 8080
