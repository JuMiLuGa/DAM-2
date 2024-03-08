package Tarea_7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CalculatorClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            String request = "5,3,+";
            outputStream.write(request.getBytes());

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String serverResponse = new String(buffer, 0, bytesRead);
            System.out.println("Respuesta del servidor: " + serverResponse);

            System.out.println("Resultado: " + serverResponse);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

