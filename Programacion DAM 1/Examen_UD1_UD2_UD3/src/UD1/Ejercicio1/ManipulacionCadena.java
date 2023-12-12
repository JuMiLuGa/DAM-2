package UD1.Ejercicio1;

public class ManipulacionCadena {
    public static void main(String[] args) {
        // Paso 1: Guardar la cadena en una variable llamada "cadena"
        String cadena = " esto es un ejemplo de una cadena de texto ";

        // Paso 2: Imprimir la cantidad de caracteres en la cadena
        System.out.println("Número de caracteres en la cadena: " + cadena.length());

        // Paso 3: Eliminar espacios en blanco al principio y al final
        cadena = cadena.trim();
        System.out.println(cadena);
        System.out.println("Número de caracteres después de eliminar espacios en blanco: " + cadena.length());

       /* // Paso 3.1: Eliminar espacios en blanco
        cadena = cadena.replace(" ", "");
        System.out.println(cadena);
        System.out.println("Número de caracteres después de eliminar espacios en blanco: " + cadena.length());
*/
        // Paso 4: Extraer la subcadena "cadena de texto" y guardarla en una variable llamada "cola"
        String cola = cadena.substring(cadena.indexOf("cadena de texto"));
        System.out.println(cola);

        // Paso 5: Reemplazar "texto" por "muestra" en "cola"
        cola = cola.replace("texto", "muestra");
        System.out.println(cola);

        // Paso 6: Extraer la subcadena "esto es un ejemplo de una" y guardarla en una variable llamada "principio"
        String principio = cadena.substring(0, 26);

        // Paso 7: Concatenar "principio" y "cola" en una variable llamada "frase"
        String frase = principio + cola;

        // Paso 8: Imprimir la variable "frase"
        System.out.println("Frase original: " + frase);

        // Paso 9: Modificar la frase para que empiece con mayúsculas
        frase = frase.substring(0, 1).toUpperCase() + frase.substring(1);

        // Paso 10: Imprimir la frase modificada
        System.out.println("Frase modificada: " + frase);
    }
}