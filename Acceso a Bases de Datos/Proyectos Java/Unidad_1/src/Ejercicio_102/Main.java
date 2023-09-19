package Ejercicio_102;

public class Main {
    public static void main(String[] args) {
        ManejoFicheros gestor = new ManejoFicheros();

        // Ejemplo de uso de los métodos
        gestor.crearFichero("C:\\Users\\dam2_alu10\\DAM-2\\Acceso a Bases de Datos\\Proyectos Java\\Prueba Ficheros\\2\\2.2\\archivo.txt");
        gestor.borrarFichero("C:\\Users\\dam2_alu10\\DAM-2\\Acceso a Bases de Datos\\Proyectos Java\\Prueba Ficheros\\2\\2.2\\archivo.txt");
        gestor.crearDirectorio("C:\\Users\\dam2_alu10\\DAM-2\\Acceso a Bases de Datos\\Proyectos Java\\Prueba Ficheros\\2\\2.2\\2.2.2");
        gestor.borrarDirectorio("C:\\Users\\dam2_alu10\\DAM-2\\Acceso a Bases de Datos\\Proyectos Java\\Prueba Ficheros\\2\\2.2\\2.2.2");
        gestor.listarDirectorio("C:\\Users\\dam2_alu10\\DAM-2\\Acceso a Bases de Datos\\Proyectos Java\\Prueba Ficheros\\2\\2.2");
    }
}
