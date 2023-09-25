package Ejercicio2;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class ServidorHilo extends Thread{
    private Socket sc;
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;

    public ServidorHilo(Socket sc,DataInputStream in, DataOutputStream out, String nombreCliente) {
        this.sc = sc;
        this.in = in;
        this.out = out;
        this.nombreCliente = nombreCliente;
    }
    
    @Override
    public void run(){
        int opcion;
        File f = new File("numeros.txt");
        boolean salir = false;
        while (!salir) {
            
            try {
                opcion = in.readInt();
                switch (opcion) {
                    case 1:
                        // Recibo el numero aleatorio
                        int numeroAleatorio = in.readInt();
                        // escribo el numero
                        escribirNumeroAleatorio(f, numeroAleatorio);
                        System.out.println("Se escribió el numero en el cliente: " + nombreCliente);
                        // Mando el mensaje de confirmacion al cliente
                        out.writeUTF("Numero guardado correctamente");
                        break;
                    
                    case 2:
                         //COMPLETAR
                        break;
                    
                    case 3:
                        ArrayList<Integer>  numeros = listaNumeros(f);
                        out.writeInt(numeros.size());
                        for (int n:numeros) {
                            out.writeInt(n);
                        }
                        break;
                    
                    case 4:
                        int numLineasCliente = numeroLineasFicheroCliente(f);
                        out.writeInt(numLineasCliente);
                        break;
                    
                    case 5:
                        salir = true;
                        break;
                                   
                    default:
                        out.writeUTF("Solo numero del 1 al 6");
                }
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
        try {
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conexión cerrada con el cliente " + nombreCliente);  
        
    }
    
    
    public void escribirNumeroAleatorio(File f,int numeroAleatorio) throws IOException{
        
        FileWriter fw = new FileWriter(f, true);
        fw.write(nombreCliente + ":"+numeroAleatorio + "\r\n");
        fw.close();
        
    }
    
    public int numeroLineasFichero(File f) throws FileNotFoundException, IOException{
        int numLineas = 0;
        BufferedReader br = new  BufferedReader(new FileReader(f));
        String linea = "";
        while((linea = br.readLine()) != null){
            numLineas ++;
        }
        br.close();
        return numLineas;
    }
    
    
    public ArrayList<Integer> listaNumeros(File f) throws FileNotFoundException, IOException{
        ArrayList<Integer> numeros = new ArrayList<>();
        
        BufferedReader br = new  BufferedReader(new FileReader(f));
        String linea = "";
        while((linea = br.readLine()) != null){
            String[] partes = linea.split(":");
            int numero = Integer.parseInt(partes[1]);
            numeros.add(numero);
        }
        br.close();
        return numeros;
    }
    
      public int numeroLineasFicheroCliente(File f) throws FileNotFoundException, IOException{
      //COMPLETAR
        return 0;
    }
        
    }

