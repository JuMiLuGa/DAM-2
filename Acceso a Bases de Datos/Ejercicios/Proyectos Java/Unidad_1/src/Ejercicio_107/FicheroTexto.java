package Ejercicio_107;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroTexto {
    private File file;

    public FicheroTexto(String filePath) {
        this.file = new File(filePath);
    }

    public File getFile() {
        return file;
    }

    public void escribir(String texto) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(texto);
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    public void leer() {
        try (FileReader reader = new FileReader(file)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }

}

