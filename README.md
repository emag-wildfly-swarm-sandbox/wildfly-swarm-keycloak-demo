# wildfly-swarm-keycloak-demo

WildFly Swarm Keycloak Demo

## Start Keycloak

``` sh
docker run -it -d \
  -p 18080:8080 \
  -v `pwd`/realm:/tmp/realm \
  jboss/keycloak:2.1.0.Final \
  -b 0.0.0.0 -Dkeycloak.migration.action=import -Dkeycloak.migration.provider=singleFile -Dkeycloak.migration.file=/tmp/realm/wildfly-swarm-realm.json
```

## Build & Run

``` sh
./mvnw clean package &&\
java -jar target/wildfly-swarm-keycloak-demo-swarm.jar
```

## Get Token

``` sh
USER=user-a
PASS=user-a-pass
RESULT=`curl -s --data "grant_type=password&client_id=curl&username=${USER}&password=${PASS}" http://localhost:18080/auth/realms/wildfly-swarm/protocol/openid-connect/token`
TOKEN=`echo $RESULT | sed 's/.*access_token":"//g' | sed 's/".*//g'`
```

## Access secret resource

``` sh
curl -H "Authorization: bearer $TOKEN" localhost:8080/secret-a
```

You'll get the response which contains `Secret A`.
