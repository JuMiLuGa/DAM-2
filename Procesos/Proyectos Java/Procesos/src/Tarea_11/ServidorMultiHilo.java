package Tarea_11;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServidorMultiHilo {

    private static volatile Socket lastSuccessfulClient;
    private static volatile Socket firstFailedClient;
    private static int failedClientCounter = 0;
    private static final Lock counterLock = new ReentrantLock();
    private static final Lock clientLock = new ReentrantLock();

    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor esperando conexiones en el puerto " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                // Crea un hilo para manejar la conexión del cliente
                Thread clientHandlerThread = new Thread(() -> handleClient(clientSocket));
                clientHandlerThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            // Envía un mensaje al cliente
            out.println("¡Hola, cliente!");

            // Almacena el último cliente conectado exitosamente
            setLastSuccessfulClient(clientSocket);

        } catch (IOException e) {
            // Almacena el primer cliente que falla la conexión
            handleFailedClient(clientSocket);
            e.printStackTrace();
        }
    }

    private static void handleFailedClient(Socket clientSocket) {
        // Sincroniza el acceso al contador para asegurar que solo el primer hilo que falla actualice la variable
        counterLock.lock();
        try {
            if (failedClientCounter == 0) {
                setFirstFailedClient(clientSocket);
                System.out.println("**************PRIMERA CONEXION EN FALLAR CONEXION*************************");
                System.out.println("PrimeraFallar: " + firstFailedClient);
            }
            failedClientCounter++;
        } finally {
            counterLock.unlock();
        }
    }

    private static void setLastSuccessfulClient(Socket clientSocket) {
        clientLock.lock();
        try {
            lastSuccessfulClient = clientSocket;
            System.out.println("**************ULTIMA CONEXION EN CONECTARSE EXITOSAMENTE*************************");
            System.out.println("UltimaConexion: " + lastSuccessfulClient);
        } finally {
            clientLock.unlock();
        }
    }

    private static void setFirstFailedClient(Socket clientSocket) {
        clientLock.lock();
        try {
            firstFailedClient = clientSocket;
        } finally {
            clientLock.unlock();
        }
    }
}
