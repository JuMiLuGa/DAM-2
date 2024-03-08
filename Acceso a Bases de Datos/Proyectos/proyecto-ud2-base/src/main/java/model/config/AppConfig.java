package model.config;

import java.sql.Connection;
import model.config.database.DatabaseConnection;
import model.config.database.Engine;
import model.config.file.BinFileHandler;
import model.config.file.FileData;
import utils.ANSI;

public class AppConfig extends BinFileHandler {
    public static final String APP_NAME = "Biblioteca";

    private FileData fileData;

    private DatabaseConnection connection;

    public AppConfig() {
        ANSI.printPurpleBg("AppConfig()");
        this.fileData = new FileData();
    }

    public FileData getFileData() {
        return this.fileData;
    }

    public void readFromFile() throws Exception {
        ANSI.printPurpleBg("AppConfig.readFromFile()");
        this.fileData = read();
        System.out.println(this.fileData);
        this.connection = this.fileData.get();
    }

    public DatabaseConnection getCurrentConnection() {
        ANSI.printPurpleBg("AppConfig.getCurrentConnection()");
        return this.connection;
    }

    public Connection getConnection() throws Exception {
        ANSI.printPurpleBg("AppConfig.getConnection()");
        return this.connection.getConnection();
    }

    public Connection getConnectionSchema() throws Exception {
        ANSI.printPurpleBg("AppConfig.getConnectionSchema()");
        return this.connection.getConnectionSchema();
    }

    public Engine getEngine() {
        return this.fileData.getEngine();
    }

    public void writeToFile(DatabaseConnection conf) throws Exception {
        ANSI.printPurpleBg("AppConfig.writeToFile()");
        System.out.println(conf);
        this.fileData.set(conf);
        write(this.fileData);
    }

    public String toString() {
        return "AppConfig{APP_NAME=BibliotecafileData=" + String.valueOf(this.fileData) + ", connection=" + String.valueOf(this.connection) + "}";
    }
}

