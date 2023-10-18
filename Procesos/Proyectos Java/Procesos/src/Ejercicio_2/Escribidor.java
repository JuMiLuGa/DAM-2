package Ejercicio_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Escribidor {

    public static void main(String[] args) throws InterruptedException {
        String string1 = args[0];

        Ecribir_Fichero(string1, "Principio");
        TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
        //Aquí estoy simulando como si el proceso estuviera haciendo "algo"
        //el primer proceso parará 1 segundo el segundo proceso parará dos segundos...
        Ecribir_Fichero(string1, "Medio");
        TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
        //Aquí estoy simulando como si el proceso estuviera haciendo "algo"
        Ecribir_Fichero(string1, "Final");
    }

    public static void Ecribir_Fichero(String string1, String etapa) {
        try {
            FileWriter fileWriter = new FileWriter("E:\\DAM-2\\Procesos\\Proyectos Java\\Procesos\\log.txt", true);
            fileWriter.write(etapa + string1 + "\n");
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}