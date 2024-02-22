package model.config.database;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.ANSI;

public class SQLiteConnection implements DatabaseConnection, Serializable {
    private static final long serialVersionUID = 1L;

    String filePath;

    public SQLiteConnection(String pathFile) {
        this.filePath = pathFile;
    }

    public SQLiteConnection() {}

    public Connection getConnection() throws SQLException {
        if (!fileExists())
            ANSI.printRedBg("El fichero SQLite no existe. Se ha creado uno nuevo.");
        String url = String.format("jdbc:sqlite://%s", new Object[] { this.filePath });
        Connection connection = DriverManager.getConnection(url);
        return connection;
    }

    public Connection getConnectionSchema() throws SQLException {
        return getConnection();
    }

    public void createSchema() {}

    public boolean isValid() {
        return (this.filePath != null && !this.filePath.isEmpty());
    }

    public boolean fileExists() {
        Path path = Paths.get(this.filePath, new String[0]);
        return Files.exists(path, new java.nio.file.LinkOption[0]);
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String toString() {
        return "SQLiteConnection{filePath='" + this.filePath + "'}";
    }
}

