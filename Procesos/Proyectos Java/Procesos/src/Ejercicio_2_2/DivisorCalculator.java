package Ejercicio_2_2;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DivisorCalculator {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Uso: DivisorCalculator <divisor>");
            System.exit(1);
        }

        int divisor = Integer.parseInt(args[0]);

        try (FileWriter writer = new FileWriter(new File("divisors.txt"), true)) {

            for (int i = 1; i <= 100; i++) {
                if (i % divisor == 0) {
                    writer.write("Divisor de " + divisor + ": " + i + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


