package Ejercicio_2;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        ProcessBuilder[] constructores = new ProcessBuilder[5];

        for (int i = 0; i < 5; i++) {
            constructores[i] = new ProcessBuilder();
            String classpath = "E:\\DAM-2\\Procesos\\Proyectos Java\\Procesos\\out\\production\\Procesos";
            String className = "Ejercicio_2.Escribidor";
            constructores[i].command("java", "-cp", classpath, className, String.valueOf(i + 1));

            constructores[i].redirectError(new File("E:\\DAM-2\\Procesos\\Proyectos Java\\Procesos\\error2.txt"));
        }

        Process p1 = constructores[0].start();
        Process p2 = constructores[1].start();
        Process p3 = constructores[2].start();

        p1.waitFor();
        p2.waitFor();

        Process p4 = constructores[3].start();

        p3.waitFor();
        p4.waitFor();

        Process p5 = constructores[4].start();
    }

}