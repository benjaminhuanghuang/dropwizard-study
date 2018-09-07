In data class getters are annotated with @JsonProperty  which allows Jackson to serialize 
and deserialize from JSON. 

```
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private int id;
    private String name;
    
    ...
 
    @JsonProperty
    public int getId() {
        return id;
    }
 
    @JsonProperty
    public String getName() {
        return name;
    }
}
```