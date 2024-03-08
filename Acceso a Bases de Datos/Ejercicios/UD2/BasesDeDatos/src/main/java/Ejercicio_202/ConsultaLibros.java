package Ejercicio_202;

import java.sql.*;

public class ConsultaLibros {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {
            Statement statement = connection.createStatement();

            System.out.println();

            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM libros");
            System.out.println("TODOS LOS DATOS DE LA tabla LIBROS:");
                mostrarResultados(resultSet1);
            System.out.println();

            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM libros WHERE autor = 'Autor1'");
            System.out.println("TODOS LOS DATOS DE AUTOR ESPECIFICADO DE LA tabla LIBROS:");
                mostrarResultados(resultSet2);
            System.out.println();

            ResultSet resultSet3 = statement.executeQuery("SELECT * FROM libros WHERE anio_publicacion < 2022");
            System.out.println("TODOS LOS DATOS DE ANTERIOR AL AÑO ESPECIFICADO DE LA tabla LIBROS:");
                mostrarResultados(resultSet3);

            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarResultados(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String titulo = resultSet.getString("titulo");
            String autor = resultSet.getString("autor");
            int anioPublicacion = resultSet.getInt("anio_publicacion");

            System.out.println("ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Año de publicación: " + anioPublicacion);
        }
    }
}