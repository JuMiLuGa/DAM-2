package Ejercicio_202;

import java.sql.*;

public class ConsultaLibros {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {
            Statement statement = connection.createStatement();

            // Consulta 1: Obtener todos los libros.
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM libros");
            // Procesar los resultados...


            // Consulta 2: Obtener los libros de un autor o autora determinada.
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM libros WHERE autor = 'Autor1'");
            // Procesar los resultados...

            // Consulta 3: Obtener los libros posteriores a un año determinado.
            ResultSet resultSet3 = statement.executeQuery("SELECT * FROM libros WHERE anio_publicacion > 2022");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
