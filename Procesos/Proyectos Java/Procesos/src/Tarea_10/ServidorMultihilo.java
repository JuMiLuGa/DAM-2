package Tarea_10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMultihilo {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);

            System.out.println("Servidor esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");

                Thread clientThread = new Thread(new ClienteHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

