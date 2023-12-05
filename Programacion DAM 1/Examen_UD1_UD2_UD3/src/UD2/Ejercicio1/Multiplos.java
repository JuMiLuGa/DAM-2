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


        if (n1 % n2 == 0){
            System.out.println("El número " + n1 + " es multiplo de " + n2);
        } else {
            System.out.println("El número " + n1 + " no es multiplo de " + n2);
        }
    }
}
