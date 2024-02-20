package Tarea_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        try {
            Socket clientSocket1 = new Socket("localhost", 12345);
            enviarMensaje(clientSocket1, "Hola, soy el Cliente 1");

            Socket clientSocket2 = new Socket("localhost", 12345);
            enviarMensaje(clientSocket2, "Hola, soy el Cliente 2");

            Socket clientSocket3 = new Socket("localhost", 12345);
            enviarMensaje(clientSocket3, "Hola, soy el Cliente 3");

            clientSocket1.close();
            clientSocket2.close();
            clientSocket3.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void enviarMensaje(Socket socket, String mensaje) throws IOException {
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        output.println(mensaje);

        String respuesta = input.readLine();
        System.out.println("Respuesta del servidor: " + respuesta);

        output.close();
        input.close();
    }
}

