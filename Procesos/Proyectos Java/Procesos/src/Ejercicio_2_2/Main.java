package Ejercicio_2_2;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Crear ProcessBuilder para los procesos de cálculo de divisores
        ProcessBuilder process2 = new ProcessBuilder("java", "-cp", "DivisorCalculator", "2");
        ProcessBuilder process3 = new ProcessBuilder("java", "-cp", "DivisorCalculator", "3");
        ProcessBuilder process4 = new ProcessBuilder("java", "-cp", "DivisorCalculator", "4");
        ProcessBuilder process6 = new ProcessBuilder("java", "-cp", "DivisorCalculator", "6");
        ProcessBuilder process12 = new ProcessBuilder("java", "-cp", "DivisorCalculator", "12");

        // Redirigir la salida de cada proceso a un archivo
        process2.redirectOutput(ProcessBuilder.Redirect.to(new File("divisors_2.txt")));
        process3.redirectOutput(ProcessBuilder.Redirect.to(new File("divisors_3.txt")));
        process4.redirectOutput(ProcessBuilder.Redirect.to(new File("divisors_4.txt")));
        process6.redirectOutput(ProcessBuilder.Redirect.to(new File("divisors_6.txt")));
        process12.redirectOutput(ProcessBuilder.Redirect.to(new File("divisors_12.txt")));

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

