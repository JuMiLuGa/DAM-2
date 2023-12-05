package UD2.Ejercicio3;

import java.util.Scanner;

public class EcuacionPrimerGrado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese los coeficientes
        System.out.print("Ingrese el coeficiente C1: ");
        double c1 = scanner.nextDouble();

        System.out.print("Ingrese el coeficiente C2: ");
        double c2 = scanner.nextDouble();

        // Resolver la ecuación C1x + C2 = 0
        if (c1 != 0) {
            double solucion = -c2 / c1;
            System.out.println("La solución de la ecuación " + c1 + "x + " + c2 + " = 0 es x = " + solucion);
        } else {
            if (c2 == 0) {
                System.out.println("La ecuación es una identidad. Tiene infinitas soluciones.");
            } else {
                System.out.println("La ecuación no tiene solución.");
            }
        }

        // Cerrar el scanner para evitar fugas de recursos
        scanner.close();
    }
}

