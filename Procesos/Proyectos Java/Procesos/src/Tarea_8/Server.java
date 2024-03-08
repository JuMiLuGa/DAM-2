package Tarea_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        final int PORT = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor  esperando conexiones en el puerto " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde la IP: " + clientSocket.getInetAddress());

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = reader.readLine();
                System.out.println("Mensaje recibido del cliente: " + clientMessage);

                if (clientMessage.equals(clientSocket.getInetAddress().getHostAddress())) {
                    writer.println("IP del cliente: " + clientSocket.getInetAddress().getHostAddress());
                } else {
                    writer.println("Error: La IP no coincide.");
                }

                clientSocket.close();

                if (clientMessage.equals("Exit")) {
                    System.out.println("Servidor cerrado.");
                    break;
                }
            }

            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
