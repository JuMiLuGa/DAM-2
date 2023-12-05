package Tarea_opcional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String logFileName = "log.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFileName))) {
            // Proceso A
            Process processA = new ProcessBuilder("java", "A").start();
            writer.write("Proceso A iniciado\n");

            // Proceso A1
            Process processA1 = new ProcessBuilder("java", "A1").start();
            writer.write("Proceso A1 iniciado\n");

            // Proceso A2
            Process processA2 = new ProcessBuilder("java", "A2").start();
            writer.write("Proceso A2 iniciado\n");

            // Espera a que A2 termine antes de iniciar B2
            processA2.waitFor();
            writer.write("Proceso A2 terminado\n");

            // Proceso B
            Process processB = new ProcessBuilder("java", "B").start();
            writer.write("Proceso B iniciado\n");

            // Proceso B1
            Process processB1 = new ProcessBuilder("java", "B1").start();
            writer.write("Proceso B1 iniciado\n");

            // Proceso B2
            Process processB2 = new ProcessBuilder("java", "B2").start();
            writer.write("Proceso B2 iniciado\n");

            // Espera a que B2 termine antes de cerrar el archivo
            processB2.waitFor();
            writer.write("Proceso B2 terminado\n");

            // Proceso B3
            Process processB3 = new ProcessBuilder("java", "B3").start();
            writer.write("Proceso B3 iniciado\n");

            // Espera a que todos los procesos terminen
            processA.waitFor();
            processA1.waitFor();
            processB.waitFor();
            processB1.waitFor();
            processB3.waitFor();

            writer.write("Todos los procesos han terminado\n");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

