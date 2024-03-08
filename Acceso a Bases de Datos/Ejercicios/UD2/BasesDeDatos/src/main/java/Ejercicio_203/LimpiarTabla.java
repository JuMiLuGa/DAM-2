package Ejercicio_203;

import java.sql.*;

class LimpiarTabla {
    private Connection connection;

    public LimpiarTabla() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:tareas.sqlite");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public void limpiarTabla() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM tareas");
            System.out.println("Registros de la tabla tareas eliminados correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al limpiar la tabla: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}