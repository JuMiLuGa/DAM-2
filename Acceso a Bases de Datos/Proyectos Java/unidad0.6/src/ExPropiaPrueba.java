import java.util.Scanner;


class ExPropia extends Exception {
    public ExPropia(String mensaje) {
        super(mensaje);
    }
}


class ExPropiaClase {

    public void solicitarNumero() throws ExPropia {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, introduce un número: ");
        int numero = scanner.nextInt();

        if (numero == 0) {
            throw new ExPropia("Se ha lanzado la excepción ExPropia.");
        }
    }
}


public class ExPropiaPrueba {
    public static void main(String[] args) {
        System.out.println("Hola");

        while (true) {
            try {
                ExPropiaClase instancia = new ExPropiaClase();
                instancia.solicitarNumero();
            } catch (ExPropia e) {
                System.out.println("Se ha capturado la excepción: " + e.getMessage());
                break;
            }
        }
    }
}
