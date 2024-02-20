package Tarea_9;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(8080);

            byte[] receiveData = new byte[1024];

            System.out.println("Servidor UDP a la escucha. Esperando a por datos...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);

                byte receivedData = receivePacket.getData()[0];
                System.out.println("Recibido del cliente: " + (char) receivedData);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String responseMessage = "OK";
                byte[] responseData = responseMessage.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);

                serverSocket.send(sendPacket);

                System.out.println("Enviada confirmación al cliente: " + responseMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

