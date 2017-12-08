# kotlin-spring-cloud-elk-example

## Service configuration

Project uses Spring Configuration Server for configuration files distribution into service instances. Most of the services (except the config service) contains only bootstrap.yml file, where is only minimum necessary configuration. 
Usually only a URL to configuration server and own port. When a service is registered in service registry, port number is random.

## Authorization

Application in this example uses detached OAuth2 service for managing authentication & authorization. Authenticated
user's details are transmitted in [JWT](https://jwt.io/) token contained in header of each http request. 

Nice explanation of how Spring Cloud Security and JWT works is described in this article [http://stytex.de/blog/2016/02/01/spring-cloud-security-with-oauth2](http://stytex.de/blog/2016/02/01/spring-cloud-security-with-oauth2).
In short, when unauthorized user requests some protected resources (from RecipeFavouritesService for example), he will be redirected
to authorization service's login page. When signed in, authorization service creates JWT token, signs it with its private key and
send it back to the user. User then sends the token in header with each HTTP request. When resource server finds the token in
request header, it verifies token with authorization server's public key and extracts user's details from the token payload.

Every oauth2 client uses client identification and secret for communication with authorization server. For simplicity, this information
is hardcoded in authorization server's bean config. On client side, identification and secret are stored in configuration files.

## Frontend

Frontend part is pure TypeScript with use of React and Redux for browser state management. There is no Spring Boot service
for serving JavaScript files and other static resources. 

Instead for development is used webpack-dev-server, which enables hot reload of React components and Redux reducers without loosing browser state.
To start webpack dev server, run command ``$ npm start``

For production environment is build docker container containing all static resources with generated JavaScript files.