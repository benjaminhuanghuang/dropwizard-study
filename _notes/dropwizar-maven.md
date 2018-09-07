## Reference
- Build a RESTful stub server with Dropwizard
    - https://automationrhapsody.com/build-a-rest-stub-server-with-dropwizard/
    - https://github.com/llatinov/sample-dropwizard-rest-stub
    
## Steps
1. Create Maven project
```
    mvn -B archetype:generate
        -DarchetypeGroupId=org.apache.maven.archetypes
        -DgroupId=com.automationrhapsody.reststub
        -DartifactId=sample-dropwizard-rest-stub
```
  -B batch mode, non-interactive
    
  -D define a property
        groupId is Java package
        artifactId this is project name:
    
  **The project can be created directly from IntelliJ**

2. Add Dropwizard dependency into pom.xml
```
    <dependency>
        <groupId>io.dropwizard</groupId>
        <artifactId>dropwizard-core</artifactId>
        <version>1.3.5</version>
    </dependency>
```

3. Build with Maven
```
    mvn package
```
 
4. Add configuration file
    
    Configurations in Dropwizard are managed with YAML.



5. Add configuration class
    
    Once we have configuration file we need a class that will handle it. 

6. Add data classes

Create data class annotated with @JsonProperty  which allows Jackson to serialize and deserialize from JSON.
Or use Lombok to reduce the amount of code of Getters and Setters generation
- https://automationrhapsody.com/get-rid-of-getters-and-setters/


7. Add service classes
In Dropwizard, the **Resource Class** actually is the RESTful service with its endpoints.
- @Path provides where the endpoint is. 
- @GET and @POST indicate the type of the request. 
- @Timed is put for analytics purposes. 
- @Produces and @Consumes provide the type of data that is being exchanged. 
- @PathParam indicates that parameter is part of the URL.

8. Add health check

The health check is a smoke test that can be called from admin panel to give you information about the status of 
the system.



9. Add Dropwizard application

In main method new application is created and its run() method is called. 
In order to actually work service and health check should be registered. This is done in the run method. 
Configuration is passed in health check’s constructor.

10. Build everything into a single JAR file
Add build config in pom.xml file
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <configuration>
    ...
    </configuration> 
    <executions>
    ...
    </executions>
</plugin>
```
Create JAR to the target folder
```
    mvn package
```
11. Run the JAR
```
    java -jar XXXX-1.0-SNAPSHOT.jar server ../config.yml
```