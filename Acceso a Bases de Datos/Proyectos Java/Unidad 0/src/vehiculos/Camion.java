package vehiculos;

public class Camion extends Vehiculo {
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