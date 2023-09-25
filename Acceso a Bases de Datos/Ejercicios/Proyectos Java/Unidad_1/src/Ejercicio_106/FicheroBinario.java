package Ejercicio_106;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicheroBinario {
    private File archivo;

    public FicheroBinario(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }

    public File getArchivo() {
        return archivo;
    }

    public void escribir(String texto) {
        try (FileOutputStream fos = new FileOutputStream(archivo)) {
            fos.write(texto.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leer() {
        try (FileInputStream fis = new FileInputStream(archivo)) {
            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copiar(FicheroBinario ficheroDestino) {
        try (FileInputStream fis = new FileInputStream(archivo);
             FileOutputStream fos = new FileOutputStream(ficheroDestino.getArchivo())) {
            int content;
            while ((content = fis.read()) != -1) {
                fos.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FicheroBinario ficheroOrigen = new FicheroBinario("archivo_origen.bin");
        FicheroBinario ficheroDestino = new FicheroBinario("archivo_destino.bin");

        ficheroOrigen.escribir("Texto de ejemplo");

        System.out.println("Contenido del archivo de origen:");
        ficheroOrigen.leer();

        ficheroOrigen.copiar(ficheroDestino);

        System.out.println("\nContenido del archivo de destino (copia):");
        ficheroDestino.leer();
    }
}

