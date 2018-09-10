package cn.huang.dropwizardstudy.data;

// Getters are annotated with @JsonProperty  which allows Jackson to serialize and deserialize from JSON.
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person() {
        // Needed by Jackson deserialization
    }

    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty
    public String getLastName() {
        return lastName;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }

        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }

        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }

        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }


        return true;
    }
}