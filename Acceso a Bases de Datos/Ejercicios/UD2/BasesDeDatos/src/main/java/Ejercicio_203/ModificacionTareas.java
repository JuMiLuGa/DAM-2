package Ejercicio_203;

import java.sql.*;

class ModificacionTareas {
    private Connection connection;

    public ModificacionTareas() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:tareas.sqlite");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public void modificarDescripcionTarea(int id, String nuevaDescripcion) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE tareas SET descripcion = ? WHERE id = ?")) {
            statement.setString(1, nuevaDescripcion);
            statement.setInt(2, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Descripción de la tarea modificada correctamente.");
            } else {
                System.out.println("No se encontró la tarea con ID " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar la descripción de la tarea: " + e.getMessage());
        }
    }

    public void modificarEstadoTarea(int id, String nuevoEstadoStr) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE tareas SET estado = ? WHERE id = ?")) {
            statement.setString(1, nuevoEstadoStr);
            statement.setInt(2, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Estado de la tarea modificado correctamente.");
            } else {
                System.out.println("No se encontró la tarea con ID " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar el estado de la tarea: " + e.getMessage());
        }
    }

    public void eliminarTarea(int id) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM tareas WHERE id = ?")) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tarea eliminada correctamente.");
            } else {
                System.out.println("No se encontró la tarea con ID " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar la tarea: " + e.getMessage());
        }
    }

    public void eliminarTareasCompletadas() {
        try (Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate("DELETE FROM tareas WHERE estado = 'COMPLETADA'");
            System.out.println(rowsAffected + " tareas completadas eliminadas correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar las tareas completadas: " + e.getMessage());
        }
    }
}