package Ejercicio_202;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Invoca las clases según sea necesario
        CrearBaseDatos.main(args);
        CrearTabla.main(args);
        CompletaLibros.main(args);
        ConsultaLibros.main(args);
        /*ModificacionLibros.main(args);
        LimpiarTabla.main(args);*/
    }
}
