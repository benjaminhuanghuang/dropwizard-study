package cn.huang.dropwizardstudy;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/*
*  Once we have configuration file we need a class that will handle it.
*  version is our custom configuration property.
*  Annotate getter and setter with @JsonProperty which allows Jackson to serialize and deserialize from JSON.
* */
public class RestServiceConfig extends Configuration {
    @NotEmpty
    private String version;

    @JsonProperty
    public String getVersion() {
        return version;
    }

    @JsonProperty
    public void setVersion(String version) {
        this.version = version;
    }
}