package Ejercicio_202;

import java.sql.*;

public class LimpiarTabla {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM libros");
            System.out.println("Registros de la tabla 'libros' eliminados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
