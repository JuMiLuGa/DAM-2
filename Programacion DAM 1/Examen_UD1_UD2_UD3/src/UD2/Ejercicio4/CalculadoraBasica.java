package UD2.Ejercicio4;

import java.util.Scanner;

public class CalculadoraBasica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();


        System.out.println("Suma: " + sumar(num1, num2));
        System.out.println("Resta: " + restar(num1, num2));
        System.out.println("Multiplicación: " + multiplicar(num1, num2));
        System.out.println("División: " + dividir(num1, num2));


        System.out.println("Potencia: " + potencia(num1));
        System.out.println("Raíz cuadrada: " + raizCuadrada(num1));


        scanner.close();
    }


    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: No se puede dividir por cero.");
            return Double.NaN;
        }
    }

    public static double potencia(double base) {
        return Math.pow(base, 2);
    }

    public static double raizCuadrada(double num) {
        return Math.sqrt(num);
    }
}

