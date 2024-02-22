package Ejercicio_206;

import java.sql.*;
import java.util.Scanner;

public class ConsultaNombres {
    public static void consultarPorLetraInicial(Connection connection) throws SQLException {
        String sql = "SELECT nomemp FROM emp WHERE nomemp LIKE ?";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la letra inicial: ");
        String letraInicial = scanner.nextLine();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, letraInicial + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nomemp"));
            }
        }
    }
}
