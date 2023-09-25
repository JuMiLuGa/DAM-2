package Ejercicio_107;

import java.io.IOException;
import java.util.Scanner;

public class ManejoFicheroTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FicheroTexto fichero = new FicheroTexto("miarchivo.txt");

        boolean salir = false;

        System.out.println("Bienvenido al programa de manejo de fichero de texto.");

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Escribir en el fichero.");
            System.out.println("2. Leer fichero.");
            System.out.println("3. Salir.");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduzca el texto que desea escribir en el fichero: ");
                    String texto = scanner.nextLine();
                    fichero.escribir(texto);
                    System.out.println("Texto escrito en el fichero.");
                    break;
                case 2:
                    System.out.println("Contenido del fichero:");
                    fichero.leer();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }

        System.out.println("¡Hasta luego!");
    }
}

