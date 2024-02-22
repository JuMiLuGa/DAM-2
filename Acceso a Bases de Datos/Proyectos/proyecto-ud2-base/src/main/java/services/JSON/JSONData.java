package services.JSON;

import java.util.ArrayList;
import model.entity.Book;
import model.entity.Member;
import model.entity.Rent;

public class JSONData {
    private ArrayList<Book> books;

    private ArrayList<Member> members;

    private ArrayList<Rent> rents;

    public JSONData(ArrayList<Book> books, ArrayList<Member> members, ArrayList<Rent> rents) {
        this.books = books;
        this.members = members;
        this.rents = rents;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Member> getMembers() {
        return this.members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public ArrayList<Rent> getRents() {
        return this.rents;
    }

    public void setRents(ArrayList<Rent> rents) {
        this.rents = rents;
    }
}

