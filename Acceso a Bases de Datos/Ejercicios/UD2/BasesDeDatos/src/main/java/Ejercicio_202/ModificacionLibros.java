package Ejercicio_202;

import java.sql.*;
public class ModificacionLibros {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {
            Statement statement = connection.createStatement();

            // Modificación 1: Modificar el título de un libro.
            statement.executeUpdate("UPDATE libros SET titulo = 'NuevoTitulo' WHERE id = 1");

            // Modificación 2: Modificar el autor o autora de un libro.
            statement.executeUpdate("UPDATE libros SET autor = 'NuevoAutor' WHERE id = 2");

            // Modificación 3: Modificar el año de publicación de un libro.
            statement.executeUpdate("UPDATE libros SET anio_publicacion = 2025 WHERE id = 3");

            // Modificación 4: Eliminar un libro.
            statement.executeUpdate("DELETE FROM libros WHERE id = 4");

            // Modificación 5: Eliminar los libros anteriores a un año determinado.
            statement.executeUpdate("DELETE FROM libros WHERE anio_publicacion < 2023");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
