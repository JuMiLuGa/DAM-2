package Ejercicio_203;

import java.sql.*;

class CompletaTareas {
    private Connection connection;

    public CompletaTareas() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:tareas.sqlite");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public void insertarTareas() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO tareas (descripcion, estado, fecha_creacion) " +
                    "VALUES ('Tarea 1', 'PENDIENTE', '2024-01-23')");
            statement.executeUpdate("INSERT INTO tareas (descripcion, estado, fecha_creacion) " +
                    "VALUES ('Tarea 2', 'EN_PROCESO', '2024-01-24')");
            statement.executeUpdate("INSERT INTO tareas (descripcion, estado, fecha_creacion) " +
                    "VALUES ('Tarea 3', 'COMPLETADA', '2024-01-25')");
            statement.executeUpdate("INSERT INTO tareas (descripcion, estado, fecha_creacion) " +
                    "VALUES ('Tarea 4', 'PENDIENTE', '2024-01-26')");
            statement.executeUpdate("INSERT INTO tareas (descripcion, estado, fecha_creacion) " +
                    "VALUES ('Tarea 5', 'EN_PROCESO', '2024-01-27')");
            System.out.println("Tareas insertadas correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar tareas: " + e.getMessage());
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