package Ejercicio_117;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionEstudiantes {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        File file = new File("estudiantes.dat");

        if (file.exists()) {
            // Cargar datos desde el archivo si existe
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                estudiantes = (List<Estudiante>) ois.readObject();
                System.out.println("Datos de estudiantes cargados desde estudiantes.dat.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar datos de estudiantes desde estudiantes.dat.");
            }
        }

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar un nuevo estudiante.");
            System.out.println("2. Mostrar información de estudiantes.");
            System.out.println("3. Guardar información de estudiantes en archivo.");
            System.out.println("4. Salir.");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Número de identificación: ");
                    int id = scanner.nextInt();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Promedio de calificaciones: ");
                    double promedio = scanner.nextDouble();

                    Estudiante nuevoEstudiante = new Estudiante(nombre, id, edad, promedio);
                    estudiantes.add(nuevoEstudiante);
                    System.out.println("Estudiante agregado con éxito.");
                    break;

                case 2:
                    System.out.println("\nInformación de estudiantes:");
                    for (Estudiante estudiante : estudiantes) {
                        System.out.println(estudiante);
                    }
                    break;

                case 3:
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                        oos.writeObject(estudiantes);
                        System.out.println("Datos de estudiantes guardados en estudiantes.dat.");
                    } catch (IOException e) {
                        System.err.println("Error al guardar datos de estudiantes en estudiantes.dat.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}