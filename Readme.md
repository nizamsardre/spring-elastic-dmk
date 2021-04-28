## Prerequisites:

1. **_Application.properties_**<br/>
   Need to configure create external property file with following attribute

```
server.port=8095
spring.data.mongodb.uri=mongodb://10.10.1.162:5556,10.10.1.162:5557,10.10.1.162:5558/dhamaka?readPreference=secondaryPreferred&maxStalenessSeconds=120&replicaSet=dhamaka_dev_rs
```

2. **_Java Version_**<br/>
   Used JDK 1.8
3. **_Maven_**
4. **_git_**

## Build

1. Clone this repository using `git clone`
2. Change current working directory into project directory using `cd`
3. Build \*.jar file using `mvn install`

There should be a jar file in target directory if the maven command is successful

## Run the Jar file


`java -jar ./target/pay-0.0.1-SNAPSHOT.jar --spring.config=Application.properties`

