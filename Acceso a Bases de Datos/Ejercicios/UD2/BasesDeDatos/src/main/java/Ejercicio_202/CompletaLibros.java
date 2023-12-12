package Ejercicio_202;

import java.sql.*;

public class CompletaLibros {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO libros (titulo, autor, anio_publicacion) VALUES ('Libro1', 'Autor1', 2020)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor, anio_publicacion) VALUES ('Libro2', 'Autor2', 2021)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor, anio_publicacion) VALUES ('Libro3', 'Autor3', 2022)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor, anio_publicacion) VALUES ('Libro4', 'Autor4', 2023)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor, anio_publicacion) VALUES ('Libro5', 'Autor5', 2024)");
            System.out.println("Libros insertados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
