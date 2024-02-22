package model.entity;

public class Book {
    private Integer id;

    private String title;

    private String author;

    public Book(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean hasId() {
        return (this.id != null);
    }

    public boolean isValid() {
        return (this.title != null && !this.title.isEmpty() && this.author != null &&
                !this.author.isEmpty());
    }

    public String toString() {
        return "Book{id=" + this.id + ", title='" + this.title + "', author='" + this.author + "'}";
    }
}

