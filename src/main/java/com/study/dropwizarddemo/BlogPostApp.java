package com.study.dropwizarddemo;

import com.study.dropwizarddemo.resources.BlogPostResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class BlogPostApp extends Application<BlogPostConfig> {
    public static void main(String[] args) throws Exception {
        new BlogPostApp().run(args);
    }

    @Override
    public void run(BlogPostConfig configuration, Environment environment) {
        final BlogPostResource resource = new BlogPostResource(configuration);
        environment.jersey().register(resource);
    }

}