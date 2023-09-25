package Ejercicio2;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        
        
        try {
            ServerSocket server = new ServerSocket(5000);
            Socket sc;
            
            System.out.println("Servidor iniciado");
            while(true){
            
                // Espero la conexion del cliente
                sc = server.accept();
                
                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());
                
                //COMPLETAR
                
                // Pido al cliente el nombre al cliente
               
                
                // Inicio el hilo
               
                
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
    
}
