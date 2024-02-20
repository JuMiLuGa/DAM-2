package Tarea_opcional_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {
    public static void main(String[] args) {
        try {
            // Crear servidor socket
            ServerSocket serverSocket = new ServerSocket(5001);

            // Aceptar conexión del Servidor 1
            Socket servidor1Socket = serverSocket.accept();

            // Configurar flujos de entrada y salida
            InputStream servidor1Input = servidor1Socket.getInputStream();
            OutputStream servidor1Output = servidor1Socket.getOutputStream();

            // Leer mensaje del Servidor 1
            byte[] buffer = new byte[1024];
            int bytesRead = servidor1Input.read(buffer);
            String mensajeServidor1 = new String(buffer, 0, bytesRead);
            System.out.println("Mensaje del Servidor 1: " + mensajeServidor1);

            // Responder al Servidor 1 (simulación)
            String respuesta = "Mensaje recibido por el Servidor 2";
            System.out.println("Enviando respuesta al Servidor 1...");
            servidor1Output.write(respuesta.getBytes());
            System.out.println("Respuesta enviada al Servidor 1.");

            // Cerrar conexiones
            servidor1Socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
