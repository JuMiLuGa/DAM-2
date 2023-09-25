package Ejercicio_104;

import java.io.File;
import java.io.FilenameFilter;

import java.io.*;

public class FiltrarTamano implements FilenameFilter {
    private float minTamano;

    public FiltrarTamano(float minTamano) {
        this.minTamano = minTamano;
    }

    @Override
    public boolean accept(File ruta, String nombre) {
        File archivo = new File(ruta, nombre);
        return archivo.isFile() && archivo.length() > minTamano;
    }

    public void filtrar(String ruta, float minTamano) {
        File directorio = new File(ruta);
        
        if (directorio.isDirectory()) {
            String[] archivosFiltrados = directorio.list(this);

            if (archivosFiltrados.length > 0) {
                System.out.println("Archivos con tamaño mayor que " + minTamano + " bytes en " + ruta + ":");
                for (String archivo : archivosFiltrados) {
                    System.out.println(archivo);
                }
            } else {
                System.out.println("No se encontraron archivos que cumplan con el tamaño especificado en " + ruta);
            }
        } else {
            System.out.println(ruta + " no es un directorio válido.");
        }
    }

    public static void main(String[] args) {
        String ruta = "C:\\Users\\dam2_alu10\\DAM-2\\Acceso a Bases de Datos\\Proyectos Java\\Prueba Ficheros\\2\\2.2";
        float minTamano = 0;
        FiltrarTamano filtro = new FiltrarTamano(minTamano);
        filtro.filtrar(ruta, minTamano);
    }
}