package Ejercicio_119;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.Scanner;

public class DirectorioAZip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la ruta del directorio que desea comprimir: ");
        String directorio = scanner.nextLine();

        File directorioEntrada = new File(directorio);

        if (!directorioEntrada.exists() || !directorioEntrada.isDirectory()) {
            System.out.println("La ruta ingresada no es un directorio válido.");
            return;
        }

        String nombreDirectorio = directorioEntrada.getName();
        String archivoZip = nombreDirectorio + ".zip";

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(archivoZip))) {
            comprimirDirectorio(directorioEntrada, nombreDirectorio, zipOut);
            System.out.println("Compresión completada con éxito. Archivo ZIP creado: " + archivoZip);
        } catch (IOException e) {
            System.err.println("Error al comprimir el directorio: " + e.getMessage());
        }
    }

    public static void comprimirDirectorio(File directorio, String nombreBase, ZipOutputStream zipOut) throws IOException {
        File[] archivos = directorio.listFiles();

        for (File archivo : archivos) {
            if (archivo.isDirectory()) {
                comprimirDirectorio(archivo, nombreBase + File.separator + archivo.getName(), zipOut);
            } else {
                FileInputStream fis = new FileInputStream(archivo);
                ZipEntry zipEntry = new ZipEntry(nombreBase + File.separator + archivo.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zipOut.write(buffer, 0, len);
                }

                fis.close();
            }
        }
    }
}

