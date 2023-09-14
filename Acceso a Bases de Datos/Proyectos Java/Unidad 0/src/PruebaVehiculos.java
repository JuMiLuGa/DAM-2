abstract class Vehiculo {
    private String color;
    private int numRuedas;
    private int cilindrada;
    private int potencia;

    public Vehiculo(String color, int numRuedas, int cilindrada, int potencia) {
        this.color = color;
        this.numRuedas = numRuedas;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    // Método abstracto para obtener el impuesto
    public abstract double obtenerImpuesto();
}

class Camion extends Vehiculo {
    private int numEjes;

    public Camion(String color, int numRuedas, int numEjes, int cilindrada, int potencia) {
        super(color, numRuedas, cilindrada, potencia);
        this.numEjes = numEjes;
    }

    public int getNumEjes() {
        return numEjes;
    }

    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }

    @Override
    public double obtenerImpuesto() {
        // Calcular el impuesto para camiones
        return getCilindrada() / 30.0 + getPotencia() * 20 + getNumRuedas() * 20 + getNumEjes() * 50;
    }
}

class Motocicleta extends Vehiculo {
    private int numOcupantes;

    public Motocicleta(String color, int cilindrada, int potencia) {
        super(color, 2, cilindrada, potencia);
    }

    public Motocicleta(String color, int cilindrada, int potencia, int numOcupantes) {
        super(color, 2, cilindrada, potencia);
        this.numOcupantes = numOcupantes;
    }

    public int getNumOcupantes() {
        return numOcupantes;
    }

    public void setNumOcupantes(int numOcupantes) {
        this.numOcupantes = numOcupantes;
    }

    @Override
    public double obtenerImpuesto() {
        // Calcular el impuesto para motocicletas
        return getCilindrada() / 30.0 + getPotencia() + 30;
    }
}

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
