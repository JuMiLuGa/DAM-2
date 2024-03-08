import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] numerosAleatorios = generarNumerosAleatorios(20);

        int[] numerosPrimos = obtenerNumerosPrimos(numerosAleatorios);

        System.out.println("Números aleatorios:");
        mostrarArray(numerosAleatorios);

        System.out.println("Números primos:");
        mostrarArray(numerosPrimos);
    }

    public static int[] generarNumerosAleatorios(int cantidad) {
        Random random = new Random();
        int[] numeros = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            numeros[i] = random.nextInt(100);
        }
        return numeros;
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] obtenerNumerosPrimos(int[] numeros) {
        int contadorPrimos = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i])) {
                contadorPrimos++;
            }
        }

        int[] primos = new int[contadorPrimos];
        int index = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i])) {
                primos[index] = numeros[i];
                index++;
            }
        }
        return primos;
    }

    public static void mostrarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
