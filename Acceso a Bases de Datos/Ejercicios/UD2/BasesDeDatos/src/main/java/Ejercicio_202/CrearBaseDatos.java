package Ejercicio_202;

import java.sql.*;

public class CrearBaseDatos {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "abc123.")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS libros");
            System.out.println("Base de datos 'libros' creada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
