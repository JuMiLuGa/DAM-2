import java.io.*;

public class FiltradorLineas {
    public static void main(String[] args) {

        String archivoEntrada = "entrada.txt";
        String archivoSalida = "salida_filtrada.txt";

        String palabra = "Java";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoSalida))) {

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                if (linea.contains(palabra)) {
                    bufferedWriter.write(linea);
                    bufferedWriter.newLine();
                }
            }
            System.out.println("Se han filtrado las líneas que contienen la palabra '" + palabra + "'.");
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        }
    }
}

