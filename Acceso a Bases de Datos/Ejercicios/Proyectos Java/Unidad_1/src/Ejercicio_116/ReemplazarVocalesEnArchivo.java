package Ejercicio_116;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReemplazarVocalesEnArchivo {
    public static void main(String[] args) {
        try {
            // Lee el archivo refranes.txt
            BufferedReader br = new BufferedReader(new FileReader("refranes.txt"));
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            br.close();

            // Solicita al usuario una vocal
            System.out.print("Introduce una vocal: ");
            char vocal = obtenerVocal();

            if (vocal != '\0') {
                // Crea el nombre del archivo resultante
                String nombreArchivoResultante = "refranes_CON_" + vocal + ".txt";

                // Reemplaza las vocales en el contenido y guarda en el archivo resultante
                String contenidoModificado = contenido.toString().replaceAll("[aeiouAEIOU]", String.valueOf(vocal));

                BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoResultante));
                bw.write(contenidoModificado);
                bw.close();

                System.out.println("Archivo resultante '" + nombreArchivoResultante + "' creado con éxito.");
            } else {
                System.out.println("Por favor, introduce una única vocal válida.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static char obtenerVocal() {
        try {
            char vocal = (char) System.in.read();
            System.in.read(); // Consume el carácter Enter
            vocal = Character.toLowerCase(vocal);

            if (vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u') {
                return vocal;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return '\0';
    }
}

