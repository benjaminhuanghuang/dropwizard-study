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

http://maven.aliyun.com/nexus/content/groups/public/

作者：国士无双A
链接：https://www.jianshu.com/p/39875424be3c
來源：简书
简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。


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

## Run application
  java -jar dropwizard-demo-standalone.jar server hello.yaml



