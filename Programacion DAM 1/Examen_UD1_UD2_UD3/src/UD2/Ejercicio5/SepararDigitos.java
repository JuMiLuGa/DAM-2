package UD2.Ejercicio5;

import java.util.Scanner;

public class SepararDigitos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese un número de 5 dígitos
        System.out.print("Ingrese un número de 5 dígitos: ");
        int numero = scanner.nextInt();

        // Verificar si el número tiene 5 dígitos
        if (numero >= 10000 && numero <= 99999) {
            // Separar y mostrar los dígitos
            System.out.print("Dígitos separados: ");
            separarYMostrarDigitos(numero);
        } else {
            System.out.println("Error: El número ingresado no tiene 5 dígitos.");
        }

        // Cerrar el scanner para evitar fugas de recursos
        scanner.close();
    }

    // Función para separar y mostrar los dígitos de un número
    public static void separarYMostrarDigitos(int numero) {
        int divisor = 10000;

        while (divisor > 0) {
            int digito = numero / divisor;
            System.out.print(digito + " ");

            numero %= divisor;
            divisor /= 10;
        }

        System.out.println(); // Salto de línea al final
    }
}

