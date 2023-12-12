package UD2.Ejercicio5;

import java.util.Scanner;

public class SepararDigitos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese un número de 5 dígitos: ");
        int numero = scanner.nextInt();


        if (numero >= 10000 && numero <= 99999) {

            System.out.print("Dígitos separados: ");
            separarYMostrarDigitos(numero);
        } else {
            System.out.println("Error: El número ingresado no tiene 5 dígitos.");
        }


        scanner.close();
    }



        public static void separarYMostrarDigitos(int numero) {
            // Se inicializa el divisor con el valor correspondiente al dígito de mayor orden del número (en este caso, 10000).
            int divisor = 10000;

            // Se utiliza un bucle while para iterar a través de los dígitos del número.
            while (divisor > 0) {
                // Se calcula el dígito actual dividiendo el número por el divisor.
                int digito = numero / divisor;

                // Se imprime el dígito actual en la consola.
                System.out.print(digito + " ");

                // Se actualiza el número eliminando el dígito que ya se ha procesado.
                numero %= divisor;

                // Se reduce el divisor para pasar al siguiente dígito de menor orden.
                divisor /= 10;
            }
            System.out.println();
        }


    }


