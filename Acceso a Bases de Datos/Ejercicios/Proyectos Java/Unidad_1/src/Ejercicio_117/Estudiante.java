package Ejercicio_117;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Estudiante implements Serializable {
    private String nombre;
    private int numeroIdentificacion;
    private int edad;
    private double promedioCalificaciones;

    public Estudiante(String nombre, int numeroIdentificacion, int edad, double promedioCalificaciones) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.edad = edad;
        this.promedioCalificaciones = promedioCalificaciones;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", ID: " + numeroIdentificacion + ", Edad: " + edad + ", Promedio: " + promedioCalificaciones;
    }
}



