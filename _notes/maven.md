Dropwizard uses Maven to manage project
## Maven pom.xml
```
  <project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.mycompany.app</groupId>
    <artifactId>my-app</artifactId>
    <version>1</version>
  </project>
```
- Group Id
- Artifact Id


## Maven Build Lifecycle
There are 3 built-in build life cycle ‘clean’, ‘default’ and ‘site’. A life cycle has multiple phases. 
‘default’ lifecycle has following phases
- compile – compiles the source code
- test – executes unit test cases
- package – bundles the compiled code (Ex: war / jar)
- install – stores the built package in local Maven repository
- deploy – store in remote repository for sharing


## Maven repository
  Default Maven repository http://repo.maven.org/maven2
  Local repository: 在Mac上，它的位置在~/.m2/repository
  当maven查找需要的jar文件时，它会先在本地库中查找，只有在找不到的情况下，才会去远程库中找的

## Create Dropwizard project
The simplest way to create a Dropwizard project is to use the **Maven archetype** called java-simple which is a part of Dropwizard. 
```
mvn archetype:generate
  -DgroupId=com.javaeeeee
  -DartifactId=DWGettingStarted
  -Dname=DWGettingStarted
  -Dpackage=com.javaeeeee.dwstart
  -DarchetypeGroupId=io.dropwizard.archetypes
  -DarchetypeArtifactId=java-simple
  -DinteractiveMode=false
```
Sample 2
```
mvn archetype:generate 
    -DgroupId=com.howtodoinjava.demo 
    -DartifactId=DropWizardExample
    -DarchetypeArtifactId=maven-archetype-quickstart 
    -DinteractiveMode=false
```

## Build
In the <build><plugins> section of your pom.xml file, add some config (https://www.dropwizard.io/0.9.1/docs/getting-started.html)

This configures Maven to do a couple of things during its package phase:
- Produce a pom.xml file which doesn’t include dependencies for the libraries whose contents are included in the fat JAR.
- Exclude all digital signatures from signed JARs. If you don’t, then Java considers the signature invalid and won’t load or run your JAR file.
- Collate the various META-INF/services entries in the JARs instead of overwriting them. (Neither Dropwizard nor Jersey works without those.)
- Set JAR’s MainClass. This will allow you to run the JAR using java -jar.

```
    mvn package
    mvn clean package
```


## Run application
```
  java -jar target/DropWizardStudy-1.0-SNAPSHOT.jar server config.yaml
```
Dropwizard takes the first command line argument and dispatches it to a matching command.
In this case, the only command available is server, which runs your application as an HTTP server and requires a configuration file,

