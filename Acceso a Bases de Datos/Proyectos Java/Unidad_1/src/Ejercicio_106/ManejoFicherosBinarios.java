package Ejercicio_106;

public class ManejoFicherosBinarios {
    public static void main(String[] args) {
        FicheroBinario ficheroOrigen = new FicheroBinario("origen.bin");
        FicheroBinario ficheroDestino = new FicheroBinario("destino.bin");

        String textoOrigen = "ESTE ES EL TEXTO DE ORIGEN.";
        ficheroOrigen.escribir(textoOrigen);

        System.out.println("Contenido de archivo origen");
        ficheroOrigen.leer();

        System.out.println("Archivo copiado");
        ficheroOrigen.copiar(ficheroDestino);

        System.out.println("Contenido de archivo destino");
        ficheroDestino.leer();
    }
}

