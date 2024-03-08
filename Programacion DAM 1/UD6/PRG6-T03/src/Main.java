import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[][] matrizNum = new int[4][5];
        Random random = new Random();

        for (int i = 0; i < matrizNum.length; i++) {
            for (int j = 0; j < matrizNum[i].length; j++) {
                matrizNum[i][j] = random.nextInt(10);
            }
        }

        int total = 0;
        for (int i = 0; i < matrizNum.length; i++) {
            int sumFila = 0;
            for (int j = 0; j < matrizNum[i].length; j++) {
                System.out.print(matrizNum[i][j] + "\t");
                sumFila += matrizNum[i][j];
                total += matrizNum[i][j];
            }
            System.out.println(" = \t" + sumFila);
        }

        for (int j = 0; j < matrizNum[0].length; j++) {
            int sumColumna = 0;
            for (int i = 0; i < matrizNum.length; i++) {
                sumColumna += matrizNum[i][j];
            }
            System.out.print("------");
        }
        System.out.println();

        System.out.println("Suma Total: " + total);
    }
}

