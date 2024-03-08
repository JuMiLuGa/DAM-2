package Ejercicio_206;

import java.sql.*;
import java.util.Scanner;

public class BorradoDepartamento {
    public static void borrarDepartamento(Connection connection) throws SQLException {
        
        String sqlDeleteEmp = "DELETE FROM emp WHERE numdep = ?";
        String sqlDeleteDepto = "DELETE FROM depto WHERE numdep = ?";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número del departamento a borrar: ");
        int numDepartamento = scanner.nextInt();

        try (PreparedStatement statement1 = connection.prepareStatement(sqlDeleteEmp);
             PreparedStatement statement2 = connection.prepareStatement(sqlDeleteDepto)) {
            statement1.setInt(1, numDepartamento);
            statement2.setInt(1, numDepartamento);

            int empDeleted = statement1.executeUpdate();
            int deptoDeleted = statement2.executeUpdate();

            if (empDeleted > 0 || deptoDeleted > 0) {
                System.out.println("Departamento y empleados asociados borrados correctamente");
            } else {
                System.out.println("No se encontró ningún departamento con ese número");
            }
        }
    }
}
