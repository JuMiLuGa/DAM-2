package Ejercicio2;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {
   

    public static void main(String[] args) {
        
        try {
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");
            
            Socket sc = new Socket("127.0.0.1", 5000);
            
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            
            //COMPLETAR            
            
            // Leer mensaje del servidor 
           
            
            // Escribe el nombre y se lo manda al servidor
           
            
            // ejecutamos el hilo
           
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
      }}}

  