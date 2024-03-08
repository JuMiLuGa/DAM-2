package Ejercicio_203;

import java.sql.*;

class CrearTabla {
    private Connection connection;

    public CrearTabla() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:tareas.sqlite");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public void crearTabla() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tareas " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "descripcion TEXT NOT NULL, " +
                    "estado TEXT NOT NULL, " +
                    "fecha_creacion TEXT NOT NULL)");
            System.out.println("Tabla creada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
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