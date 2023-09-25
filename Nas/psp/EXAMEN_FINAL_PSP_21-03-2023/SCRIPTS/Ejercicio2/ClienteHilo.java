package Ejercicio2;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class ClienteHilo extends Thread{
    private DataInputStream in;
    private DataOutputStream out;

    public ClienteHilo(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    public void run(){
        
    Scanner sn = new Scanner(System.in);

        String mensaje;
        int opcion = 0;
        boolean salir = false;

        while (!salir) {

            try {
                System.out.println("1. Almacenar número en el archivo");
                System.out.println("2. Cuántos números almacenados hasta el momento");
                System.out.println("3. Lista de números almacenados");
                System.out.println("4. El número de números almacenados por el cliente");
                System.out.println("5. Salir");
                
                opcion = sn.nextInt();
                out.writeInt(opcion);
                
                switch (opcion) {
                    case 1:  //COMPLETAR
                        // Genero un numero aleatorio
                       
                        // Le mando al servidor el numero aleatorio
                       
                        // Recibo y muestro el mensaje
                       
                        break;
                    case 2: //COMPLETAR
                        
                        break;
                    case 3: //COMPLETAR
                       
                        break;
                    case 4: 
                        int numLineasCliente = in.readInt();
                        System.out.println("Hay " + numLineasCliente + " números de este cliente");
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        mensaje = in.readUTF();
                        System.out.println(mensaje);
                        
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    
        
    }
     public int generaNumeroAleatorio(int minimo,int maximo){
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
   }
    
}
