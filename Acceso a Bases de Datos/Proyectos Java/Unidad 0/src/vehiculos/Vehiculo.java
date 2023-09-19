package vehiculos;

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
