package vehiculos;

public class Motocicleta extends Vehiculo {
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
