export const environment = {
  production: true,
  api: 'http://keycloak-nginx-proxy/api',

  keycloak: {
    url: 'http://keycloak-nginx-proxy/auth',
    realm: 'keycloak-nginx-test',
    clientId: 'frontend',
  },
};
