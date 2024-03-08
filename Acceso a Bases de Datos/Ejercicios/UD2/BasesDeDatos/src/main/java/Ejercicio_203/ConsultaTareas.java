package Ejercicio_203;

import java.sql.*;

class ConsultaTareas {
    private Connection connection;

    public ConsultaTareas() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:tareas.sqlite");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public void obtenerTodasLasTareas() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM tareas")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descripcion = resultSet.getString("descripcion");
                EstadoTarea estado = EstadoTarea.valueOf(resultSet.getString("estado"));
                String fechaCreacion = resultSet.getString("fecha_creacion");

                Tarea tarea = new Tarea(id, descripcion, estado, fechaCreacion);

                System.out.println("ID: " + tarea.getId() + ", Descripción: " + tarea.getDescripcion() +
                        ", Estado: " + tarea.getEstado() + ", Fecha de Creación: " +
                        tarea.getFechaCreacion());
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todas las tareas: " + e.getMessage());
        }
    }

    public void obtenerTareasDespuesDeFecha(String fecha) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM tareas WHERE fecha_creacion > ?")) {
            statement.setString(1, fecha);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descripcion = resultSet.getString("descripcion");
                EstadoTarea estado = EstadoTarea.valueOf(resultSet.getString("estado"));
                String fechaCreacion = resultSet.getString("fecha_creacion");

                Tarea tarea = new Tarea(id, descripcion, estado, fechaCreacion);

                System.out.println("ID: " + tarea.getId() + ", Descripción: " + tarea.getDescripcion() +
                        ", Estado: " + tarea.getEstado() + ", Fecha de Creación: " +
                        tarea.getFechaCreacion());
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tareas después de la fecha: " + e.getMessage());
        }
    }

    public void obtenerTareasPorEstado(String estadoStr) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM tareas WHERE estado = ?")) {
            statement.setString(1, estadoStr);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descripcion = resultSet.getString("descripcion");
                EstadoTarea estado = EstadoTarea.valueOf(resultSet.getString("estado"));
                String fechaCreacion = resultSet.getString("fecha_creacion");

                Tarea tarea = new Tarea(id, descripcion, estado, fechaCreacion);

                System.out.println("ID: " + tarea.getId() + ", Descripción: " + tarea.getDescripcion() +
                        ", Estado: " + tarea.getEstado() + ", Fecha de Creación: " +
                        tarea.getFechaCreacion());
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tareas por estado: " + e.getMessage());
        }
    }
}