package UD2.Ejercicio1;

import java.util.Scanner;

public class Multiplos {
    public static void main(String[] args){

        int n1 = 0;
        int n2 = 0;
        boolean primo = true;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Escriba el primer número: ");
        n1 = scanner.nextInt();

        System.out.println();

        System.out.print("Escriba el segundo número: ");

        n2 = scanner.nextInt();


        verificarMultiplo(n1,n2);
    }

    private static void verificarMultiplo(int num1, int num2){
        if (num1 % num2 == 0){
            System.out.println("El número " + num1 + " es multiplo de " + num2);
        } else {
            System.out.println("El número " + num1 + " no es multiplo de " + num2);
        }
    }
}
