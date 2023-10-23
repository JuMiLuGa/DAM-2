package Ejercicio_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Escribidor {

    public static void main(String[] args) throws InterruptedException {
        String string1 = args[0];

        Escribir_Fichero(string1, "Principio");
        TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
        Escribir_Fichero(string1, "Medio");
        TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
        Escribir_Fichero(string1, "Final");
    }

    public static void Escribir_Fichero(String string1, String etapa) {
        try {
            FileWriter fileWriter = new FileWriter("E:\\DAM-2\\Procesos\\Proyectos Java\\Procesos\\log2.txt", true);
            fileWriter.write(etapa + string1 + "\n");
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}