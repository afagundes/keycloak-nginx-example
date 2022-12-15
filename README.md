# Keycloak Nginx Proxy

An example application that demonstrates how to configure authentication with Keycloak 20.0.1 running behind a reverse proxy.

# Pre requisites

+ JDK 17
+ Docker
+ Docker Compose

# Running the application

Simply enter the following commands into your terminal:

```shell
make build
make run
```

The build script may prompt you for your password as it attempts to modify your /etc/hosts file to include the domain **keycloak-nginx-proxy**.

# Accessing the application

After running the previous commands, launch your browser and navigate to http://keycloak-nginx-proxy.

| Username | Password |
|----------|----------|
| admin    | admin    |
