package Ejercicio_204;

import java.math.BigDecimal;
import java.sql.*;

public class ConsultasEmpleados {

    private static final String URL = "jdbc:mysql://localhost/empleados";
    private static final String USER = "usuario";
    private static final String PASSWORD = "contraseña";

    public static void main(String[] args) {
        obtenerEmpleados();
        obtenerDepartamentos();
        obtenerEmpleadosContables();
        obtenerEmpleadosContablesOrdenados();
        obtenerEmpleadosContablesOrdenadosInverso();
        obtenerNombreSalarioEmpleados();
        obtenerNombresDepartamentos();
        obtenerNombresDepartamentosOrdenados();
        obtenerNombrePuestoEmpleadosOrdenadosPorSalario();
        obtenerNombrePuestoEmpleadosOrdenadosPorEmpleoSalario();
        obtenerSalarioComisionDepartamento3();
        obtenerSalarioComisionDepartamento3OrdenadosPorComision();
        obtenerDiferentesComisiones();
        obtenerNuevosSalariosConBonus();
        obtenerEmpleadosComisionSuperiorMitadSalario();
        obtenerEmpleadosComisionMenorIgualCuartoSueldo();
        obtenerSalarioComisionEmpleadosNumeroSuperior7500();
        obtenerEmpleadosSinComisionOrdenadosPorNumero();
        obtenerSalarioComisionSalarioTotalEmpleados();
        obtenerEmpleadosDepartamento1SinCadenaLA();
        obtenerNombresDepartamentosNoVentasNoAdministracionOrdenadosPorLocalidad();
        obtenerNombreDepartamentoComercialesNoDepartamento1SalarioSuperior800OrdenadosPorFecha();
        obtenerNombresEmpleadosMasCincoCaracteres();
        obtenerSalarioMaximoTotalComisionesTotalEmpleados();
        obtenerDepartamentosMasDeTresEmpleados();
        obtenerDosEmpleadosMayorSalario();
        obtenerEmpleadosSalarioSuperiorMedia();
        obtenerEmpleadosSalarioMasBajoPorDepartamento();
        obtenerDepartamentosSinEmpleados();
        obtenerDepartamentoSumaSalariosMasAlta();
        obtenerEmpleadosNoSupervisados();
        obtenerEmpleadosSantiagoVilagarcia();
        obtenerEmpleadosMayorSalarioPorDepartamento();

        actualizarBD();
    }

    // Consulta 1: Datos completos de los empleados
    public static void obtenerEmpleados() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM emp")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getString("nomemp") + " "
                        + resultSet.getString("puesto") + " "
                        + resultSet.getDate("feccont") + " "
                        + resultSet.getBigDecimal("sal") + " "
                        + resultSet.getBigDecimal("comision") + " "
                        + resultSet.getInt("numdep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 2: Datos completos de los departamentos
    public static void obtenerDepartamentos() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM depto")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numdep") + " "
                        + resultSet.getString("nomdep") + " "
                        + resultSet.getString("localidad") + " "
                        + resultSet.getInt("numjefe"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 3: Datos de los empleados con puesto CONTABLE
    public static void obtenerEmpleadosContables() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE puesto = 'CONTABLE'")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getString("nomemp") + " "
                        + resultSet.getString("puesto") + " "
                        + resultSet.getDate("feccont") + " "
                        + resultSet.getBigDecimal("sal") + " "
                        + resultSet.getBigDecimal("comision") + " "
                        + resultSet.getInt("numdep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Consulta 4: Datos de los empleados con puesto CONTABLE, ordenados por el nombre
        public static void obtenerEmpleadosContablesOrdenados() {
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE puesto = 'CONTABLE' ORDER BY nomemp")) {

                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("numemp") + " "
                            + resultSet.getString("nomemp") + " "
                            + resultSet.getString("puesto") + " "
                            + resultSet.getDate("feccont") + " "
                            + resultSet.getBigDecimal("sal") + " "
                            + resultSet.getBigDecimal("comision") + " "
                            + resultSet.getInt("numdep"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    // Consulta 5: Datos de los empleados con puesto CONTABLE, ordenados por el nombre en orden inverso al alfabético
        public static void obtenerEmpleadosContablesOrdenadosInverso() {
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE puesto = 'CONTABLE' ORDER BY nomemp DESC")) {

                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("numemp") + " "
                            + resultSet.getString("nomemp") + " "
                            + resultSet.getString("puesto") + " "
                            + resultSet.getDate("feccont") + " "
                            + resultSet.getBigDecimal("sal") + " "
                            + resultSet.getBigDecimal("comision") + " "
                            + resultSet.getInt("numdep"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    // Consulta 6: El nombre y salario de los empleados
    public static void obtenerNombreSalarioEmpleados() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT nomemp, sal FROM emp")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nomemp") + " "
                        + resultSet.getBigDecimal("sal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 7: Los nombres de los departamentos
    public static void obtenerNombresDepartamentos() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT nomdep FROM depto")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nomdep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 8: Los nombres de los departamentos, ordenados por localidad
    public static void obtenerNombresDepartamentosOrdenados() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT nomdep FROM depto ORDER BY localidad")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nomdep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 9: El nombre y puesto de los empleados, ordenados por salario (de mayor a menor)
    public static void obtenerNombrePuestoEmpleadosOrdenadosPorSalario() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT nomemp, puesto FROM emp ORDER BY sal DESC")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nomemp") + " " + resultSet.getString("puesto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 10: El nombre y puesto de los empleados, ordenados por empleo y salario
    public static void obtenerNombrePuestoEmpleadosOrdenadosPorEmpleoSalario() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT nomemp, puesto FROM emp ORDER BY puesto, sal DESC")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nomemp") + " " + resultSet.getString("puesto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 11: Los salarios y las comisiones de los empleados del departamento 3
    public static void obtenerSalarioComisionDepartamento3() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT sal, comision FROM emp WHERE numdep = 3")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getBigDecimal("sal") + " " + resultSet.getBigDecimal("comision"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 12: Los salarios y las comisiones de los empleados del departamento 3, ordenados por comisión
    public static void obtenerSalarioComisionDepartamento3OrdenadosPorComision() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT sal, comision FROM emp WHERE numdep = 3 ORDER BY comision")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getBigDecimal("sal") + " " + resultSet.getBigDecimal("comision"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 13: Las diferentes comisiones de los empleados.
    public static void obtenerDiferentesComisiones() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT DISTINCT comision FROM emp")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getBigDecimal("comision"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 14: Los nuevos salarios que resultarían de sumar a los empleados del departamento 3 un bonus de 1000 euros.
    public static void obtenerNuevosSalariosConBonus() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            int filasActualizadas = statement.executeUpdate("UPDATE emp SET sal = sal + 1000 WHERE numdep = 3");

            System.out.println("Se han actualizado " + filasActualizadas + " salarios con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 15: Los empleados que tienen una comisión superior a la mitad de su salario.
    public static void obtenerEmpleadosComisionSuperiorMitadSalario() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE comision > sal / 2")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getString("nomemp") + " "
                        + resultSet.getBigDecimal("sal") + " "
                        + resultSet.getBigDecimal("comision"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 16: Los empleados cuya comisión es menor o igual que el 25% de su sueldo.
    public static void obtenerEmpleadosComisionMenorIgualCuartoSueldo() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE comision <= sal * 0.25")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getString("nomemp") + " "
                        + resultSet.getBigDecimal("sal") + " "
                        + resultSet.getBigDecimal("comision"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 17: El salario y la comisión de los empleados cuyo número de empleado supere el 7500.
    public static void obtenerSalarioComisionEmpleadosNumeroSuperior7500() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT sal, comision FROM emp WHERE numemp > 7500")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getBigDecimal("sal") + " " + resultSet.getBigDecimal("comision"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 18: Aquellos empleados que no tienen comisión, ordenados por número de empleado.
    public static void obtenerEmpleadosSinComisionOrdenadosPorNumero() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE comision IS NULL OR comision = 0 ORDER BY numemp")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getString("nomemp") + " "
                        + resultSet.getBigDecimal("sal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 19: El salario, la comisión y el salario total de todos los empleados.
    public static void obtenerSalarioComisionSalarioTotalEmpleados() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT numemp, sal, comision, (sal + IFNULL(comision, 0)) AS salario_total FROM emp")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getBigDecimal("sal") + " "
                        + resultSet.getBigDecimal("comision") + " "
                        + resultSet.getBigDecimal("salario_total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 20: Los empleados del departamento 1 cuyo nombre no contiene la cadena LA.
    public static void obtenerEmpleadosDepartamento1SinCadenaLA() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE numdep = 1 AND nomemp NOT LIKE '%LA%'")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getString("nomemp") + " "
                        + resultSet.getString("puesto") + " "
                        + resultSet.getDate("feccont") + " "
                        + resultSet.getBigDecimal("sal") + " "
                        + resultSet.getBigDecimal("comision") + " "
                        + resultSet.getInt("numdep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 21: Los nombres de los departamentos que no sean de VENTAS ni de ADMINISTRACIÓN, ordenados por localidad.
    public static void obtenerNombresDepartamentosNoVentasNoAdministracionOrdenadosPorLocalidad() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT nomdep FROM depto WHERE nomdep NOT IN ('VENTAS', 'ADMINISTRACION') ORDER BY localidad")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nomdep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 22: El nombre y el departamento de los comerciales que no trabajan en el departamento 1 y cuyo salario es superior a 800, ordenados por la fecha de incorporación.
    public static void obtenerNombreDepartamentoComercialesNoDepartamento1SalarioSuperior800OrdenadosPorFecha() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT emp.nomemp, depto.nomdep " +
                     "FROM emp INNER JOIN depto ON emp.numdep = depto.numdep " +
                     "WHERE emp.puesto = 'COMERCIAL' AND emp.numdep != 1 AND emp.sal > 800 " +
                     "ORDER BY emp.feccont")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nomemp") + " "
                        + resultSet.getString("nomdep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 23: Los nombres de empleados que tengan al menos 5 caracteres.
    public static void obtenerNombresEmpleadosMasCincoCaracteres() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT nomemp FROM emp WHERE LENGTH(nomemp) >= 5")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nomemp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 24: El salario máximo de la empresa, el total destinado a comisiones y el número total de empleados.
    public static void obtenerSalarioMaximoTotalComisionesTotalEmpleados() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT MAX(sal) AS salario_maximo FROM emp");
            resultSet.next();
            BigDecimal salarioMaximo = resultSet.getBigDecimal("salario_maximo");

            resultSet = statement.executeQuery("SELECT SUM(IFNULL(comision, 0)) AS total_comisiones FROM emp");
            resultSet.next();
            BigDecimal totalComisiones = resultSet.getBigDecimal("total_comisiones");

            resultSet = statement.executeQuery("SELECT COUNT(*) AS total_empleados FROM emp");
            resultSet.next();
            int totalEmpleados = resultSet.getInt("total_empleados");

            System.out.println("Salario máximo: " + salarioMaximo);
            System.out.println("Total destinado a comisiones: " + totalComisiones);
            System.out.println("Número total de empleados: " + totalEmpleados);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 25: Los departamentos que tienen más de 3 empleados.
    public static void obtenerDepartamentosMasDeTresEmpleados() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT numdep FROM emp GROUP BY numdep HAVING COUNT(*) > 3")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numdep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 26: Los 2 empleados con mayor salario.
    public static void obtenerDosEmpleadosMayorSalario() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM emp ORDER BY sal DESC LIMIT 2")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getString("nomemp") + " "
                        + resultSet.getBigDecimal("sal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 27: Los empleados cuyo salario supera o coincide con la media del salario de la empresa.
    public static void obtenerEmpleadosSalarioSuperiorMedia() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE sal >= (SELECT AVG(sal) FROM emp)")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getString("nomemp") + " "
                        + resultSet.getBigDecimal("sal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 28: Los empleados con el salario más bajo de cada departamento.
    public static void obtenerEmpleadosSalarioMasBajoPorDepartamento() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT numdep, MIN(sal) AS salario_mas_bajo FROM emp GROUP BY numdep");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numdep") + " " + resultSet.getBigDecimal("salario_mas_bajo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 29: Los departamentos que no tienen empleados.
    public static void obtenerDepartamentosSinEmpleados() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT numdep FROM depto WHERE numdep NOT IN (SELECT numdep FROM emp)")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numdep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 30: El departamento cuya suma de salarios sea la más alta.
    public static void obtenerDepartamentoSumaSalariosMasAlta() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT numdep FROM emp GROUP BY numdep ORDER BY SUM(sal) DESC LIMIT 1")) {

            if (resultSet.next()) {
                System.out.println(resultSet.getInt("numdep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 31: Los empleados que no son supervisados por ningún otro.
    public static void obtenerEmpleadosNoSupervisados() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE numemp NOT IN (SELECT numjefe FROM depto)")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getString("nomemp") + " "
                        + resultSet.getString("puesto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 32: Los empleados que trabajen en SANTIAGO o VILAGARCIA.
    public static void obtenerEmpleadosSantiagoVilagarcia() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE numdep IN (SELECT numdep FROM depto WHERE localidad IN ('SANTIAGO', 'VILAGARCIA'))")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getString("nomemp") + " "
                        + resultSet.getString("puesto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consulta 33: Los empleados con mayor salario de cada departamento.
    public static void obtenerEmpleadosMayorSalarioPorDepartamento() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT emp.numemp, emp.nomemp, emp.sal, emp.numdep " +
                    "FROM emp INNER JOIN (" +
                    "   SELECT numdep, MAX(sal) AS max_salario " +
                    "   FROM emp " +
                    "   GROUP BY numdep" +
                    ") AS max_sal ON emp.numdep = max_sal.numdep AND emp.sal = max_sal.max_salario");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("numemp") + " "
                        + resultSet.getString("nomemp") + " "
                        + resultSet.getBigDecimal("sal") + " "
                        + resultSet.getInt("numdep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Modificacion Base de Datos.
    public static void actualizarBD() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false); // Desactivar el modo de confirmación automática

            statement = connection.createStatement();

            // Cambiar el nombre del empleado con número de empleado 7499 a JORGE
            statement.executeUpdate("UPDATE emp SET nomemp = 'JORGE' WHERE numemp = 7499");

            // Cambiar la localidad del departamento OPERACIONES a MADRID
            statement.executeUpdate("UPDATE depto SET localidad = 'MADRID' WHERE nomdep = 'OPERACIONES'");

            // Poner un salario de 3000 euros a todos los empleados con código superior a 7800
            statement.executeUpdate("UPDATE emp SET sal = 3000 WHERE numemp > 7800");

            // Borrar los datos del empleado FORD
            statement.executeUpdate("DELETE FROM emp WHERE nomemp = 'FORD'");

            // Borrar los datos del empleado 7934
            statement.executeUpdate("DELETE FROM emp WHERE numemp = 7934");

            // Borrar los datos del departamento número 3
            statement.executeUpdate("DELETE FROM depto WHERE numdep = 3");

            connection.commit(); // Confirmar los cambios en la base de datos
            System.out.println("Se han actualizado los datos en la base de datos correctamente.");
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Deshacer los cambios en caso de error
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException statementCloseException) {
                    statementCloseException.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException connectionCloseException) {
                    connectionCloseException.printStackTrace();
                }
            }
        }
    }
}

