package model.config.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {
    Connection getConnection() throws SQLException;

    Connection getConnectionSchema() throws SQLException;

    void createSchema() throws SQLException;

    boolean isValid();
}
