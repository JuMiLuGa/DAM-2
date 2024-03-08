package Ejercicio_206;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost/empleados";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "abc123.";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Consultar nombres de empleados por letra inicial");
            System.out.println("2. Borrar empleado por número");
            System.out.println("3. Consultar empleados por comisión");
            System.out.println("4. Borrar departamento y empleados");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    ConsultaNombres.consultarPorLetraInicial(connection);
                    break;
                case 2:
                    BorradoEmpleados.borrarEmpleado(connection);
                    break;
                case 3:
                    ConsultaComision.consultarPorComision(connection);
                    break;
                case 4:
                    BorradoDepartamento.borrarDepartamento(connection);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

