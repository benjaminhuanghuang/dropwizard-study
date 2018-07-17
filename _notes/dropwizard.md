## Libraries in Dropwizard
Dropwizard集成了Java生态系统中各个问题域中最优秀的组件，帮助开发者快速的打造一个Rest风格的后台服务。
- Jetty for HTTP: 每一个应用程序被打包成一个jar（而不是war）文件，并开始自己的嵌入式Jetty容器。没有任何war文件和外部servlet容器。
- Jersey for REST: Jersey（JAX-RS的参考实现）是用来写基于REST的Web服务的。
- Jackson for JSON: 用来做所有的JSON处理。
- Metrics for metrics: 支持监控使用标准库，它在监控代码方面有无与伦比的洞察力。
- Log: 使用Logback和SLF4J完成
- Hibernate Validator: 使用Hibernate验证API进行声明性验证。
- Guava:


## Dropwizard vs Spring Boot
- Spring的依赖
Spring Boot聚焦于Spring应用，如果你希望进入Spring生态环境，或者已经熟悉它，希望有一个快速起步，那么选择它是好的选择，而DropWizard是将其REST和Jersey结合在一起，它帮助你离开对Spring的依赖。

- Http服务器
这里我们看到Spring Boot更加灵活，Dropwizard以约定优于配置，比Spring Boot更极端点，完全是基于Jetty，而Spring Boot默认使用嵌入的Tomcat，其他也可以选择。

- Log
Dropwizard 从log4j切换到LogBack，而Spring boot提供 Logback, log4j 和 log4j2选择，LogBack是一个更好的Log4j，性能要比log4j提高，不过要注意不同的方法使用性能不同。

- 依赖注入
两个框架主要区别是依赖注入的不同，Spring核心有依赖注入，而DropWizard需要你选择，这也带来了灵活性，有Google Guice或更新更好的依赖注入框架可供选择。

- Testing
两个框架都有 dropwizard-testing 和 spring-boot-starter-test支持。

两者都有很强很大的社区支持。如果你更喜欢轻量，无疑Dropwizard胜出，如果你已经有Spring经验，无疑使用Spring Boot。


## Dropwizard RESTful Service
用Dropwizard写一个RESTful Service至少需要这么几个部分：一是Configuration，二是Service，然后是Resource。因为Dropwizard中已经包括了最常用和最好用的几个开源库，这样编写一个Service会方便和快捷很多。Configuration主要是作为Serivce本身的配置，通过Service可以访问对应的Resource。
- Configration

## Dropwizard dependencies
```
    <dependency>
        <groupId>io.dropwizard</groupId>
        <artifactId>dropwizard-core</artifactId>
        <version>0.8.5</version>
    </dependency>
```