package cn.huang.dropwizardstudy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class BlogPostConfig extends Configuration {
    String text;

    @JsonProperty
    public String getText() {
        return this.text;
    }

    @JsonProperty
    public void setText(String text) {
        this.text = text;
    }
}