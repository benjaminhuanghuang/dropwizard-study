Dropwizard uses Maven to manage project

##  Create Dropwizard project
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





