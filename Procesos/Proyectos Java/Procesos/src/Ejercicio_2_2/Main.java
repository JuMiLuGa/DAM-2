package Ejercicio_2_2;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Ruta de la clase
        String classPath = "E:\\DAM-2\\Procesos\\Proyectos Java\\Procesos\\out\\production\\Procesos";

        // Nombre de la clase
        String className = "Ejercicio_2_2.DivisorCalculator";

        // Crear ProcessBuilder para los procesos de cálculo de divisores
        ProcessBuilder process2 = new ProcessBuilder("java", "-cp", classPath, className, String.valueOf(2));
        ProcessBuilder process3 = new ProcessBuilder("java", "-cp", classPath, className, String.valueOf(3));
        ProcessBuilder process4 = new ProcessBuilder("java", "-cp", classPath, className, String.valueOf(4));
        ProcessBuilder process6 = new ProcessBuilder("java", "-cp", classPath, className, String.valueOf(6));
        ProcessBuilder process12 = new ProcessBuilder("java", "-cp", classPath, className, String.valueOf(12));



        // Iniciar los procesos

        Process p2 = process2.start();
        Process p3 = process3.start();
        p2.waitFor();
        p3.waitFor();

        Process p4 = process4.start();
        p4.waitFor();

        Process p6 = process6.start();
        p6.waitFor();

        Process p12 = process12.start();
        p12.waitFor();

        System.out.println("Procesos finalizados.");
    }
}

