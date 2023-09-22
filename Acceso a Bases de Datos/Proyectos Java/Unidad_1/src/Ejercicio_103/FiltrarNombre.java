package Ejercicio_103;

import java.io.File;
import java.io.FilenameFilter;

public class FiltrarNombre implements FilenameFilter {

    private String extension;

    public FiltrarNombre(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File directorio, String nombreArchivo) {
        return nombreArchivo.endsWith("." + extension);
    }

    public void filtrar(String ruta, String extension) {
        File directorio = new File(ruta);

        if (directorio.isDirectory()) {
            String[] archivos = directorio.list(new FiltrarNombre(extension));

            if (archivos != null && archivos.length > 0) {
                System.out.println("Archivos con extensión '" + extension + "' en la ruta '" + ruta + "':");
                for (String archivo : archivos) {
                    System.out.println(archivo);
                }
            } else {
                System.out.println("No se encontraron archivos con la extensión '" + extension + "' en la ruta '" + ruta + "'.");
            }
        } else {
            System.out.println("La ruta proporcionada no es un directorio válido.");
        }
    }

    public static void main(String[] args) {
        String ruta = "C:\\Users\\dam2_alu10\\DAM-2\\Acceso a Bases de Datos\\Proyectos Java\\Prueba Ficheros\\2\\2.2";
        String extensionDeseada = "txt";

        FiltrarNombre filtro = new FiltrarNombre(extensionDeseada);
        filtro.filtrar(ruta, extensionDeseada);
    }
}

