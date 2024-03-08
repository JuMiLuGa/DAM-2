
import java.io.FileInputStream;
import java.io.IOException;

public class LectorArchivoBinario {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("datos.bin")) {
            int byteLeido;
            while ((byteLeido = fileInputStream.read()) != -1) {
                System.out.print(byteLeido + " ");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

