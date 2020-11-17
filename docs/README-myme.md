
mvn clean flyway:migrate -Dflyway.configFile=myFlywayConfig.properties
mvn flyway:info -Dflyway.configFile=myFlywayConfig.properties

http://localhost:8080/h2-console,
