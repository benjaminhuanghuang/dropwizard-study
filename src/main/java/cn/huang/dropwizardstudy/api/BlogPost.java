package cn.huang.dropwizardstudy.api;

public class BlogPost {
    long id;
    String message;

    public BlogPost() {

    }

    public BlogPost(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
