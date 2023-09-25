package Ejercicio_108;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Persona personaOriginal = new Persona("Juan", 30);

        File fichero = new File("persona.txt");

        SerializarPersona serializador = new SerializarPersona();
        serializador.escribirPersonaEnFichero(personaOriginal, fichero);
        System.out.println("Datos de la persona escritos en el fichero.");

        Persona personaLeida = serializador.leerPersonaDeFichero(fichero);

        if (personaLeida != null) {
            System.out.println("Datos de la persona recuperados del fichero:");
            System.out.println("Nombre: " + personaLeida.getNombre());
            System.out.println("Edad: " + personaLeida.getEdad());
        } else {
            System.out.println("No se pudo recuperar la persona del fichero.");
        }
    }
}