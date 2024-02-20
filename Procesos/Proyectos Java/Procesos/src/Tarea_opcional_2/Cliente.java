package Tarea_opcional_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Conectar con el Servidor 1
            Socket clienteSocket = new Socket("localhost", 5000);

            // Configurar flujos de entrada y salida
            InputStream servidor1Input = clienteSocket.getInputStream();
            OutputStream servidor1Output = clienteSocket.getOutputStream();

            // Enviar mensaje al Servidor 1
            String mensaje = "Hola desde el cliente";
            servidor1Output.write(mensaje.getBytes());

            // Leer respuesta del Servidor 1
            byte[] buffer = new byte[1024];
            int bytesRead = servidor1Input.read(buffer);
            if (bytesRead > 0) {
                String respuestaServidor1 = new String(buffer, 0, bytesRead);
                System.out.println("Respuesta del Servidor 1: " + respuestaServidor1);
            } else {
                System.out.println("No se recibieron datos del Servidor 1");
            }

            // Cerrar conexión
            clienteSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
