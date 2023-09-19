import vehiculos.Camion;
import vehiculos.Motocicleta;

public class PruebaVehiculos {
    public static void main(String[] args) {
        Motocicleta moto1 = new Motocicleta("Rojo", 125, 25);
        Motocicleta moto2 = new Motocicleta("Verde", 125, 25, 2);
        Camion camion1 = new Camion("Azul", 4, 2, 4000, 300);
        Camion camion2 = new Camion("Blanco", 24, 6, 15000, 0);

        moto1.setNumOcupantes(1);
        System.out.println("Cilindrada de la segunda moto: " + moto2.getCilindrada());

        camion2.setPotencia(800);

        System.out.println("\nImpuesto de Camión 1: " + camion1.obtenerImpuesto());
        System.out.println("Impuesto de Camión 2: " + camion2.obtenerImpuesto());

        System.out.println("\nImpuesto de Motocicleta 1: " + moto1.obtenerImpuesto());
        System.out.println("Impuesto de Motocicleta 2: " + moto2.obtenerImpuesto());
    }
}
