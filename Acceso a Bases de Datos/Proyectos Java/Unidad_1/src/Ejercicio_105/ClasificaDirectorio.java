package Ejercicio_105;

import java.io.File;
import java.io.FilenameFilter;

import java.io.File;
import java.util.Arrays;

public class ClasificaDirectorio {

    public void segunExtension(String dir) {
        File directorio = new File(dir);

        if (!directorio.isDirectory()) {
            System.out.println("El directorio especificado no existe.");
            return;
        }



        File[] archivos = directorio.listFiles();

        if (archivos == null || archivos.length == 0) {
            System.out.println("El directorio está vacío.");
            return;
        }

        for (File archivo : archivos) {
            if (archivo.isFile()) {
                String nombreArchivo = archivo.getName();
                String extension = obtenerExtension(nombreArchivo);

                File subdirectorio = new File(directorio, extension.toUpperCase());
                if (!subdirectorio.exists()) {
                    subdirectorio.mkdir();
                }

                File nuevoArchivo = new File(subdirectorio, nombreArchivo);
                archivo.renameTo(nuevoArchivo);
            }
        }

        System.out.println("Archivos clasificados exitosamente.");
    }

    private String obtenerExtension(String nombreArchivo) {
        int puntoIndex = nombreArchivo.lastIndexOf(".");
        if (puntoIndex > 0) {
            return nombreArchivo.substring(puntoIndex + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        ClasificaDirectorio clasificador = new ClasificaDirectorio();
        clasificador.segunExtension("C:\\Users\\dam2_alu10\\DAM-2\\Acceso a Bases de Datos\\Proyectos Java\\Prueba Ficheros\\2\\2.2");
    }
}

