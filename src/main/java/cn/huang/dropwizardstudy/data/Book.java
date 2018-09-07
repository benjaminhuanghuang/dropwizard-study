package cn.huang.dropwizardstudy.data;
// Use Lombok to reduce the amount of code of Getters and Setters generation
// https://automationrhapsody.com/get-rid-of-getters-and-setters/
import lombok.Data;

@Data
public class Book {
    private String isbn;
    private String name;
    private String author;

    public Book(String isbn, String name, String author) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
    }

    public String getIsbn() {
        return "ISBN: " + isbn;
    }
}
