package Ejercicio_206;

import java.sql.*;
import java.util.Scanner;

public class BorradoEmpleados {
    public static void borrarEmpleado(Connection connection) throws SQLException {
        String sql = "DELETE FROM emp WHERE numemp = ?";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de empleado a borrar: ");
        int numEmpleado = scanner.nextInt();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, numEmpleado);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Empleado borrado correctamente");
            } else {
                System.out.println("No se encontró ningún empleado con ese número");
            }
        }
    }
}
