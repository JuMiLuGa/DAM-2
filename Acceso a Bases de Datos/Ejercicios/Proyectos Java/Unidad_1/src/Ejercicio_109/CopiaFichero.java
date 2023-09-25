package Ejercicio_109;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

public class CopiaFichero {
    public static void main(String[] args) {
        // Rutas de los archivos de origen y destino
        Path origenPath = Paths.get("dir", "origen.txt");
        Path destinoPath = Paths.get("dir", "destino.txt");

        try {
            // Verificar si los archivos de origen y destino existen
            if (Files.exists(origenPath) && Files.exists(destinoPath)) {
                // Copiar el contenido de origen.txt en destino.txt
                Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Contenido de origen.txt copiado exitosamente en destino.txt.");
            } else {
                System.out.println("Los archivos de origen y/o destino no existen.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
