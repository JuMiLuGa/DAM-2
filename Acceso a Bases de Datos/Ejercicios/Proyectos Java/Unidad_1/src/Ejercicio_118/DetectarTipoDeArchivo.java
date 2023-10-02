package Ejercicio_118;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DetectarTipoDeArchivo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        try {
            System.out.print("Ingrese la ruta completa del archivo: ");
            String ruta = scn.nextLine();

            FileInputStream fileInputStream = new FileInputStream(ruta);
            byte[] bytes = new byte[8];
            int lecturaBytes = fileInputStream.read(bytes);
            fileInputStream.close();

            if (lecturaBytes < 8) {
                System.out.println("No se pudieron leer suficientes bytes para determinar el tipo de archivo.");
            } else {
                String tipoArchivo = detectarTipo(bytes);
                if (tipoArchivo != null) {
                    System.out.println("Tipo de archivo detectado: " + tipoArchivo);
                } else {
                    System.out.println("No se pudo determinar el tipo de archivo.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al abrir o leer el archivo: " + e.getMessage());
        } finally {
            scn.close();
        }
    }

    public static String detectarTipo(byte[] bytes) {
        if (bytes[0] == 0x25 && bytes[1] == 0x50 && bytes[2] == 0x44 && bytes[3] == 0x46) {
            return "PDF";
        } else if (bytes[0] == 0x50 && bytes[1] == 0x4B && bytes[2] == 0x03 && bytes[3] == 0x04) {
            return "ZIP";
        } else if (bytes[0] == 0x37 && bytes[1] == 0x7A && bytes[2] == 0xBC && bytes[3] == 0xAF) {
            return "7Z";
        } else if (bytes[0] == 0x52 && bytes[1] == 0x61 && bytes[2] == 0x72 && bytes[3] == 0x21) {
            return "RAR";
        } else if (bytes[0] == 0x89 && bytes[1] == 0x50 && bytes[2] == 0x4E && bytes[3] == 0x47) {
            return "PNG";
        } else {
            return null;
        }
    }
}
