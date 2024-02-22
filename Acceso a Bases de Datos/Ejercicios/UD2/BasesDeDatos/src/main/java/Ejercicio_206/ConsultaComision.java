package Ejercicio_206;

import java.sql.*;
import java.util.Scanner;

public class ConsultaComision {
    public static void consultarPorComision(Connection connection) throws SQLException {
        String sql = "SELECT nomemp FROM emp WHERE comision = ?";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor de la comisión: ");
        double comision = scanner.nextDouble();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, comision);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nomemp"));
            }
        }
    }
}
