import java.util.Scanner;

public class Suma {
    public static void main(String[] args) {

        int num1;
        int num2;
        int suma;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca dos numeros para sumarlos");
        System.out.println("");

        System.out.print("Introduzca el primer numero: ");
        num1 = sc.nextInt();

        System.out.println("");

        System.out.print("Introduzca el segundo numero: ");
        num2 = sc.nextInt();

        System.out.println();

        suma = num1 + num2;

        System.out.println("La suma de los numeros " + num1 + " y " + num2 + " es igual a " + suma);

        sc.close();

    }
}