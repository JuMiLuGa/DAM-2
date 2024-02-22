import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        int maximo = numeros[0];
        int minimo = numeros[0];
        int indiceMaximo = 0;
        int indiceMinimo = 0;

        for (int i = 1; i < 10; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
                indiceMaximo = i;
            }
            if (numeros[i] < minimo) {
                minimo = numeros[i];
                indiceMinimo = i;
            }
        }

        System.out.println("El máximo valor es: " + maximo);
        System.out.println("El mínimo valor es: " + minimo);
        System.out.println("El máximo valor fue introducido en la posición: " + (indiceMaximo + 1));
        System.out.println("El mínimo valor fue introducido en la posición: " + (indiceMinimo + 1));

        scanner.close();
    }
}

