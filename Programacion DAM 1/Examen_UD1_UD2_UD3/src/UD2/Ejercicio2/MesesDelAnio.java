package UD2.Ejercicio2;

public class MesesDelAnio {
    // Enumerado para los meses del año
    public enum Mes {
        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
    }

    public static void main(String[] args) {
        // a. Crear una variable m del tipo enumerado y asignarle el mes de marzo.
        Mes m = Mes.MARZO;

        // Mostrar por pantalla su valor.
        System.out.println("Valor de m: " + m);

        // b. Asignar a la variable m, la cadena de texto "MARZO".
        // Mostrar por pantalla el valor de la variable de tipo enumerado tras realizar la asignación.
        try {
            m = Mes.valueOf("MARZO");
            System.out.println("Valor de m después de asignar 'MARZO': " + m);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: No se puede asignar 'MARZO' directamente a la variable de tipo enumerado.");
        }

        try {
            m = Mes.valueOf("MES RANDOM");
            System.out.println("Valor de m después de asignar 'MES RANDOM': " + m);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: No se puede asignar 'MES RANDOM' ya que no coincide con ningún valor del enumerado.");
        }
    }
}

