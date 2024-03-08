package model.config.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection implements DatabaseConnection, Serializable {
    private static final long serialVersionUID = 1L;

    private String host;

    private String port;

    private String username;

    private String password;

    private String schema;

    public MySQLConnection(String host, String port, String username, String password, String schema) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.schema = schema;
    }

    public MySQLConnection() {}

    public Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%s", new Object[] { this.host, this.port });
        Connection connection = DriverManager.getConnection(url, this.username, this.password);
        if (connection == null)
            throw new SQLException("No se puede establecer la conexicon el RDBMS");
        return connection;
    }

    public Connection getConnectionSchema() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%s/%s", new Object[] { this.host, this.port, this.schema });
        Connection connection = DriverManager.getConnection(url, this.username, this.password);
        if (connection == null)
            throw new SQLException("No se puede establecer la conexicon el schema");
        return connection;
    }

    public void createSchema() throws SQLException {
        Connection c = getConnection();
        Statement statement = c.createStatement();
        statement.execute("CREATE DATABASE " + this.schema);
    }

    public boolean isValid() {
        return (this.host != null && !this.host.isEmpty() && this.port != null &&
                !this.port.isEmpty() && this.username != null &&
                !this.username.isEmpty() && this.password != null &&
                !this.password.isEmpty() && this.schema != null &&
                !this.schema.isEmpty());
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return this.port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchema() {
        return this.schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String toString() {
        return "MySQLConnection{host='" + this.host + "', port='" + this.port + "', username='" + this.username + "', password='" + this.password + "', schema='" + this.schema + "'}";
    }
}
