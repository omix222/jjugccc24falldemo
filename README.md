# Build

sdk use java 21-open  

./mvnw liberty:dev

http://localhost:9080/jjug-demoapp/api/hello

# Open Liberty 24.0.0.9-beta 用

sdk use java 21-open  

/opt/openliberty/24.0.0.9-beta/wlp/bin/server run Server01

mvn package

cp target/jjugdemo.war /opt/openliberty/24.0.0.9-beta/wlp/usr/servers/Server01/dropins

- MicroProfile OpenAPI 4.0のため、OpenAPI v3.1 documents をデフォルトで作成してくれる。なお前のバージョンだとv3.0となっている。
http://localhost:9080/openapi/ui/

http://localhost:9080/jjug-demoapp/api/hello

http://localhost:9080/metrics/

