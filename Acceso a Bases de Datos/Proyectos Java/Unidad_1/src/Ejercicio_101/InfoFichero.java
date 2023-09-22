package Ejercicio_101;

import java.util.Scanner;
import java.io.File;

public class InfoFichero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Pedir la ruta y guardarla
        System.out.print("Introduzca una ruta: ");
        File ruta = new File(sc.nextLine());

        //Comprobar si existe o no y mostrar el mensaje adecuado
        if (ruta.exists() == true) {
            System.out.println("Nombre: " + ruta.getName());
            System.out.println("Ruta relativa: " + ruta.getPath());
            System.out.println("Ruta absoluta: " + ruta.getAbsolutePath());
            System.out.println("Permiso lectura: " + ruta.canRead());
            System.out.println("Permiso escritura: " + ruta.canWrite());
            System.out.println("Tamaño: " + ruta.length()/1000000 + " MB");
            if (ruta.isFile() == true) {
                System.out.println("Es un fichero");
            } else {
                System.out.println("Es un directorio");
            }

        } else {
            System.out.println("El fichero/directorio no existe");
        }

    }
}
