package Tarea_5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        try {

            FileOutputStream logFile = new FileOutputStream(new File("log.txt"));
            PrintStream logStream = new PrintStream(logFile);

            Banco banco = new Banco(logStream);
            Thread[] clientes = new Thread[3];

            for (int i = 0; i < clientes.length; i++) {
                clientes[i] = new Thread(new Cliente(banco));
                clientes[i].start();
            }

            for (Thread cliente : clientes) {
                try {
                    cliente.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("Saldo final del banco: " + banco.balance());
            System.out.println();

            logStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Las transacciones realizadas estan guardadas en el archivo: log.txt");
    }
}
