import java.io.Serializable;

public class Game implements Serializable {
    static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String publisher;
    private int year;

    public Game(int id, String title, String publisher, int year) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public Game(String id, String title, String publisher, String year) {
        this.id = Integer.parseInt(id);
        this.title = title;
        this.publisher = publisher;
        this.year = Integer.parseInt(year);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }
}
