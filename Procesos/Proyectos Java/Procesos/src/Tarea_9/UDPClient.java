package Tarea_9;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 8080;

            String message = "DatagramPacket";
            byte[] sendData = message.getBytes();

            for (byte data : sendData) {
                DatagramPacket sendPacket = new DatagramPacket(new byte[]{data}, 1, serverAddress, serverPort);

                clientSocket.send(sendPacket);

                System.out.println("Enviado al servidor: " + (char) data);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                clientSocket.receive(receivePacket);

                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Respuesta del servidor: " + serverResponse);
            }

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

