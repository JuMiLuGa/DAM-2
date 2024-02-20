package Tarea_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClienteHandler implements Runnable {
    private Socket clientSocket;

    public ClienteHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String mensajeCliente = input.readLine();
            System.out.println("Mensaje recibido: " + mensajeCliente);

            Thread.sleep(5000);

            output.println("Mensaje recibido. ¡Vuelva pronto!");

            input.close();
            output.close();
            clientSocket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


