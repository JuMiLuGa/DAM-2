package Ejercicio_203;

import java.sql.*;
import java.util.Scanner;

public class CrearBaseDatos {

    private static final String NOMBRE_BASE_DATOS = "tareas.sqlite";

    public void crearBaseDatos() {
        Connection conexion = null;

        try {
            Class.forName("org.sqlite.JDBC");

            conexion = DriverManager.getConnection("jdbc:sqlite:" + NOMBRE_BASE_DATOS);

            if (baseDeDatosExiste()) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("La base de datos ya existe. ¿Desea eliminarla? (S/n): ");
                String respuesta = scanner.nextLine().trim().toUpperCase();

                if (respuesta.equals("S")) {
                    eliminarBaseDeDatos(conexion);
                    System.out.println("La base de datos ha sido eliminada.");
                } else {
                    System.out.println("Operación cancelada. La base de datos no ha sido modificada.");
                }
            }
                System.out.println("Base de datos creada correctamente.");
            } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private boolean baseDeDatosExiste() {
        return NOMBRE_BASE_DATOS != null && NOMBRE_BASE_DATOS.trim().length() > 0;
    }

    private void eliminarBaseDeDatos(Connection conexion) throws SQLException {
        Statement statement = conexion.createStatement();
        statement.execute("DROP TABLE IF EXISTS tarea");
        statement.close();
    }
}
