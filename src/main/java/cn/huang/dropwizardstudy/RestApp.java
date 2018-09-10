package cn.huang.dropwizardstudy;

import cn.huang.dropwizardstudy.resources.BookService;
import cn.huang.dropwizardstudy.resources.PersonService;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class RestApp extends Application<RestServiceConfig> {

    public static void main(String[] args) throws Exception {
        new RestApp().run(args);
    }

    @Override
    public void run(RestServiceConfig config, Environment env) {
        // Register services
        env.jersey().register(new PersonService());

        // Register health check
        env.healthChecks().register("template", new RestCheck(config.getVersion()));
    }
}
