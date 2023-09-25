package Ejercicio_110;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

public class moverFichero {
    public static void main(String[] args) {
        Path origenPath = Paths.get("dir", "origen.txt");
        Path destinoPath = Paths.get("dir", "subdirectorio", "destino-sub.txt");

        try {
            if (Files.exists(origenPath) && Files.exists(destinoPath.getParent())) {
                Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Contenido de origen.txt movido exitosamente en subdirectorio como destino-sub.txt.");
            } else {
                System.out.println("Los archivos de origen y/o destino no existen.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

