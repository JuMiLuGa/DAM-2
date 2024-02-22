package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.config.database.Engine;
import model.entity.Book;
import utils.ANSI;
import utils.Util;

public class DAOBook extends DAO {
    private Connection connection;

    private Engine engine;

    private ArrayList<Book> list;

    public static final String TABLE_NAME = "books";

    public DAOBook(Connection connection, ArrayList<Book> list, Engine engine) {
        this.connection = connection;
        this.list = list;
        this.engine = engine;
        checkTable();
    }

    public DAOBook(Connection connection, Engine engine) {
        this(connection, new ArrayList<>(), engine);
    }

    private void checkTable() {
        Util.executeSQLFromTableName(this.connection, this.engine, "books");
    }

    public void dropTable() throws Exception {
        String sql = String.format("DROP TABLE %s", new Object[] { "books" });
        Statement st = this.connection.createStatement();
        st.execute(sql);
    }

    public void resetTable() throws Exception {
        dropTable();
        checkTable();
    }

    public void save(Book book) throws Exception {
        if (book.hasId()) {
            saveWithId(book);
        } else {
            saveWithoutId(book);
        }
    }

    public ArrayList<Book> all() throws Exception {
        ANSI.printCyan("DAOBook.all()");
        String sql = String.format("SELECT * FROM %s", new Object[] { "books" });
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Book> rows = new ArrayList<>();
        while (rs.next())
            rows.add(new Book(
                    Integer.valueOf(rs.getInt("id")), rs
                    .getString("title"), rs
                    .getString("author")));
        return rows;
    }

    public void importAll(ArrayList<Book> books) throws Exception {
        ANSI.printCyan("DAOBook.importAll()");
        resetTable();
        for (Book book : books)
            save(book);
    }

    private void saveWithoutId(Book book) throws Exception {
        ANSI.printCyan("DAOBook.saveWithoutId()");
        String sql = String.format("INSERT INTO %s (title, author) VALUES(?, ?);", new Object[] { "books" });
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.executeUpdate();
    }

    private void saveWithId(Book book) throws Exception {
        ANSI.printCyan("DAOBook.saveWithId()");
        String sql = String.format("INSERT INTO %s (id, title, author) VALUES(?, ?, ?);", new Object[] { "books" });
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1, book.getId().intValue());
        ps.setString(2, book.getTitle());
        ps.setString(3, book.getAuthor());
        ps.executeUpdate();
    }

    public String[][] getAvailable() throws Exception {
        String subquery = String.format("SELECT id FROM %s LEFT JOIN %s ON %s.id = %s.idBook WHERE startRentDate IS NOT NULL AND endRentDate IS NULL", new Object[] { "books", "rents", "books", "rents" });
        String sql = String.format("SELECT * FROM %s LEFT JOIN %s ON %s.id = %s.idBook WHERE id NOT IN (%s)", new Object[] { "books", "rents", "books", "rents", subquery });
        System.out.println(sql);
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<String[]> rows = (ArrayList)new ArrayList<>();
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("title"), rs.getString("author") };
            rows.add(row);
        }
        String[][] data = (String[][])rows.stream().toArray(x$0 -> new String[x$0][]);
        return data;
    }

    public String[][] getRented() throws Exception {
        String sql = String.format("SELECT * FROM %s LEFT JOIN %s ON %s.id = %s.idBook WHERE startRentDate IS NOT NULL AND endRentDate IS NULL", new Object[] { "books", "rents", "books", "rents", "members", "members", "rents" });
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<String[]> rows = (ArrayList)new ArrayList<>();
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("title"), rs.getString("author") };
            rows.add(row);
        }
        String[][] data = (String[][])rows.stream().toArray(x$0 -> new String[x$0][]);
        return data;
    }

    public int getAvaliableCount() throws Exception {
        String subquery = String.format("SELECT id FROM %s LEFT JOIN %s ON %s.id = %s.idBook WHERE startRentDate IS NOT NULL AND endRentDate IS NULL", new Object[] { "books", "rents", "books", "rents" });
        String sql = String.format("SELECT COUNT(*) FROM %s LEFT JOIN %s ON %s.id = %s.idBook WHERE id NOT IN (%s)", new Object[] { "books", "rents", "books", "rents", subquery });
        Statement st = this.connection.createStatement();
        System.out.println(sql);
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        return count;
    }

    public int getRentedCount() throws Exception {
        String sql = String.format("SELECT COUNT(*) FROM %s LEFT JOIN %s ON %s.id = %s.idBook WHERE startRentDate IS NOT NULL AND endRentDate IS NULL", new Object[] { "books", "rents", "books", "rents", "members", "members", "rents" });
        Statement st = this.connection.createStatement();
        System.out.println(sql);
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        return count;
    }
}

