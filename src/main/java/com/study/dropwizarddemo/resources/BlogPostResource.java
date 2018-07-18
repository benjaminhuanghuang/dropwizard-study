package com.study.dropwizarddemo.resources;

import com.study.dropwizarddemo.BlogPostConfig;
import com.study.dropwizarddemo.api.BlogPost;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/blog-post")
@Produces(MediaType.APPLICATION_JSON)
public class BlogPostResource {

    private final String text;

    public BlogPostResource(BlogPostConfig config)
    {
        this.text = config.getText();
    }

    @GET
    @Timed
    public BlogPost get(@QueryParam("id") long id){
        return new BlogPost(id, this.text);
    }
}
