package cn.huang.dropwizardstudy.resources;

import cn.huang.dropwizardstudy.data.Book;
import cn.huang.dropwizardstudy.persistence.BookDB;
import com.codahale.metrics.annotation.Timed;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BookService {

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return BookDB.getAll();
    }
}
