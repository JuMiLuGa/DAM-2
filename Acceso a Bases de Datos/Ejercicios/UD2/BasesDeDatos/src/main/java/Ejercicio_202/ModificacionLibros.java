package Ejercicio_202;

import java.sql.*;
public class ModificacionLibros {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {
            Statement statement = connection.createStatement();

            statement.executeUpdate("UPDATE libros SET titulo = 'NuevoTitulo' WHERE id = 1");

            statement.executeUpdate("UPDATE libros SET autor = 'NuevoAutor' WHERE id = 2");

            statement.executeUpdate("UPDATE libros SET anio_publicacion = 2025 WHERE id = 3");

            statement.executeUpdate("DELETE FROM libros WHERE id = 4");

            statement.executeUpdate("DELETE FROM libros WHERE anio_publicacion < 2023");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
