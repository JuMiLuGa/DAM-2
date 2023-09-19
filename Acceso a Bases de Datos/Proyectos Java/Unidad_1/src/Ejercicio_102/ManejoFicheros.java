package Ejercicio_102;

import java.io.File;
import java.io.IOException;

public class ManejoFicheros {

    public void crearFichero(String fichero) {
        try {
            File archivo = new File(fichero);
            if (archivo.createNewFile()) {
                System.out.println("Se ha creado el fichero: " + fichero);
            } else {
                System.out.println("El fichero ya existe: " + fichero);
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }
    }

    public void borrarFichero(String fichero) {
        File archivo = new File(fichero);
        if (archivo.delete()) {
            System.out.println("Se ha borrado el fichero: " + fichero);
        } else {
            System.out.println("No se pudo borrar el fichero: " + fichero);
        }
    }

    public void crearDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (directorio.mkdirs()) {
            System.out.println("Se ha creado el directorio: " + ruta);
        } else {
            System.out.println("El directorio ya existe: " + ruta);
        }
    }

    public void borrarDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (directorio.delete()) {
            System.out.println("Se ha borrado el directorio: " + ruta);
        } else {
            System.out.println("No se pudo borrar el directorio: " + ruta);
        }
    }

    public void listarDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            System.out.println("Contenido del directorio " + ruta + ":");
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    System.out.println("Fichero: " + archivo.getName());
                } else if (archivo.isDirectory()) {
                    System.out.println("Directorio: " + archivo.getName());
                }
            }
        } else {
            System.out.println("La ruta especificada no es un directorio: " + ruta);
        }
    }
}

