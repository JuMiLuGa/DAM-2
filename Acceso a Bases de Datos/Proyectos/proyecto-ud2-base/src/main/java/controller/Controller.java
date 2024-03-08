package controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.config.AppConfig;
import model.config.database.DatabaseConnection;
import model.config.database.Engine;
import model.config.database.MySQLConnection;
import model.config.database.SQLiteConnection;
import model.dao.DAOBook;
import model.dao.DAOMember;
import model.dao.DAORent;
import model.entity.Book;
import model.entity.Member;
import model.entity.Rent;
import services.JSON.JSON;
import services.JSON.JSONData;
import services.Mailer.Mailer;
import services.OpenLibrary;
import services.QR;
import utils.ANSI;
import view.DatabaseConfigView;
import view.MainView;
import view.alert.ErrorAlert;

public class Controller {
    private static final Controller MAIN_CONTROLLER = new Controller();

    private Connection connection;

    private Engine engine;

    private AppConfig config;

    private DAOBook daoBook;

    private DAOMember daoMember;

    private DAORent daoRent;

    public static Controller getInstance() {
        return MAIN_CONTROLLER;
    }

    public void start() {
        ANSI.printBlue("Controller.start()");
        try {
            this.config = new AppConfig();
            this.config.readFromFile();
            this.connection = this.config.getConnection();
            this.engine = this.config.getEngine();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
            openConfigView();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            openConfigView();
            return;
        }
        try {
            this.connection = this.config.getConnectionSchema();
        } catch (Exception e) {
            try {
                this.config.getCurrentConnection().createSchema();
            } catch (SQLException ex) {
                ErrorAlert.showError("Ha ocurrido un error grave que no permite arrancar la aplicación");
                return;
            }
        }
        setupDAO();
        (new MainView(this)).setVisible(true);
    }

    public void stop() {
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupDAO() {
        this.daoBook = new DAOBook(this.connection, this.engine);
        this.daoMember = new DAOMember(this.connection, this.engine);
        this.daoRent = new DAORent(this.connection, this.engine);
    }

    public void openConfigView() {
        ANSI.printBlue("Controller.openConfigView()");
        DatabaseConfigView configView = new DatabaseConfigView(null, this);
        configView.setVisible(true);
    }

    public int addTrendBooksFromAPI() throws Exception {
        ANSI.printBlue("Controller.addTrendBooksFromAPI()");
        ArrayList<Book> books = OpenLibrary.getTrending();
        for (Book book : books) {
            try {
                addBook(book);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return books.size();
    }

    public void saveMySQLProperties(MySQLConnection conf) {
        ANSI.printBlue("Controller.saveMySQLProperties()");
        System.out.println(conf);
        try {
            this.config.writeToFile((DatabaseConnection)conf);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveSQliteProperties(SQLiteConnection conf) {
        ANSI.printBlue("Controller.saveSQliteProperties()");
        System.out.println(conf);
        try {
            this.config.writeToFile((DatabaseConnection)conf);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MySQLConnection getMySQLProperties() {
        ANSI.printBlue("Controller.getMySQLProperties()");
        MySQLConnection mysql = (MySQLConnection)this.config.getFileData().get(Engine.mysql);
        System.out.println(mysql);
        return mysql;
    }

    public SQLiteConnection getSQLiteProperties() {
        ANSI.printBlue("Controller.getSQLiteProperties()");
        SQLiteConnection sqlite = (SQLiteConnection)this.config.getFileData().get(Engine.sqlite);
        System.out.println(sqlite);
        return sqlite;
    }

    public void addBook(Book book) throws Exception {
        ANSI.printBlue("Controller.addBook()");
        System.out.println(book);
        this.daoBook.save(book);
    }

    public String[][] getAvaliableBooks() throws Exception {
        ANSI.printBlue("Controller.getAvaliableBooks()");
        return this.daoBook.getAvailable();
    }

    public String[][] getRentedBooks() throws Exception {
        ANSI.printBlue("Controller.getRentedBooks()");
        return this.daoBook.getRented();
    }

    public String[][] getRentHistory() throws Exception {
        ANSI.printBlue("Controller.getRentHistory()");
        return this.daoRent.getRented();
    }

    public void addMember(Member member) throws Exception {
        ANSI.printBlue("Controller.addMember()");
        System.out.println(member);
        this.daoMember.save(member);
    }

    public String[][] getMembers() throws Exception {
        ANSI.printBlue("Controller.getMembers()");
        return this.daoMember.getAll();
    }

    public Connection getConnection() {
        return this.connection;
    }

    public AppConfig getConfig() {
        return this.config;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public boolean canRentNewBook() throws Exception {
        ANSI.printBlue("Controller.canRentNewBook()");
        return (this.daoBook.getAvaliableCount() > 0 && this.daoMember.getCount() > 0);
    }

    public boolean canFinishRents() throws Exception {
        ANSI.printBlue("Controller.canFinishRents()");
        return (this.daoBook.getRentedCount() > 0);
    }

    public String startRent(int idBook, String dniMember) throws Exception {
        ANSI.printBlue("Controller.startRent()");
        Rent rent = new Rent(Integer.valueOf(idBook), dniMember);
        String uuid = rent.getUuid();
        this.daoRent.save(rent);
        return uuid;
    }

    public void sendEmailStartRent(String uuid, String dniMember) throws Exception {
        Member member = this.daoMember.getByDni(dniMember);
        String data = uuid;
        String path = uuid + ".png";
        QR.generate(data, path);
        String to = member.getEmail();
        Mailer.startRentMessage(to, uuid);
        Files.delete(Paths.get(path, new String[0]));
    }

    public boolean endRent(String uuidRent) throws Exception {
        ANSI.printBlue("Controller.endRent()");
        Rent rent = this.daoRent.getRentedByUUID(uuidRent);
        System.out.println(rent);
        if (rent == null)
            return false;
        rent.setEndRentDate(new Timestamp(System.currentTimeMillis()));
        this.daoRent.update(rent);
        return true;
    }

    public void exportJSON(String path) throws Exception {
        ANSI.printBlue("Controller.exportJSON()");
        ArrayList<Book> books = this.daoBook.all();
        ArrayList<Member> members = this.daoMember.all();
        ArrayList<Rent> rents = this.daoRent.all();
        JSONData data = new JSONData(books, members, rents);
        JSON.exportFile(path, data);
    }

    public void importJSON(String path) throws Exception {
        ANSI.printBlue("Controller.importJSON()");
        JSONData data = JSON.importFile(path);
        ArrayList<Book> books = data.getBooks();
        ArrayList<Member> members = data.getMembers();
        ArrayList<Rent> rents = data.getRents();
        this.daoBook.importAll(books);
        this.daoMember.importAll(members);
        this.daoRent.importAll(rents);
    }
}

