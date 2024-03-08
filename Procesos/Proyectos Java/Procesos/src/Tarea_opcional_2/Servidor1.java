package Tarea_opcional_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor1 {
    public static void main(String[] args) {
        try {
            // Crear servidor socket
            ServerSocket serverSocket = new ServerSocket(5000);

            // Conectar con el Servidor 2
            Socket servidor2Socket = new Socket("localhost", 5001);

            // Aceptar conexión del cliente
            Socket clienteSocket = serverSocket.accept();

            // Configurar flujos de entrada y salida
            InputStream clienteInput = clienteSocket.getInputStream();
            OutputStream servidor2Output = servidor2Socket.getOutputStream();
            OutputStream clienteOutput = clienteSocket.getOutputStream();

            // Leer mensaje del cliente
            byte[] buffer = new byte[1024];
            int bytesRead = clienteInput.read(buffer);
            String mensajeCliente = new String(buffer, 0, bytesRead);
            System.out.println("Mensaje del cliente: " + mensajeCliente);

            // Enviar mensaje al Servidor 2
            System.out.println("Enviando mensaje al Servidor 2...");
            servidor2Output.write(buffer, 0, bytesRead);
            System.out.println("Mensaje enviado al Servidor 2.");

            // Leer respuesta del Servidor 2
            bytesRead = servidor2Socket.getInputStream().read(buffer);
            String respuestaServidor2 = new String(buffer, 0, bytesRead);
            System.out.println("Respuesta del Servidor 2: " + respuestaServidor2);

            // Enviar respuesta al cliente
            System.out.println("Enviando respuesta al cliente...");
            clienteOutput.write(buffer, 0, bytesRead);
            System.out.println("Respuesta enviada al cliente.");

            // Cerrar conexiones
            clienteSocket.close();
            servidor2Socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
