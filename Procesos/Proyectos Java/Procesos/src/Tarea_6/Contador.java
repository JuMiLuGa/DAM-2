package Tarea_6;

public class Contador {
    private int total = 0;

    public synchronized void increment() {
        total++;
    }

    public int getTotal() {
        return total;
    }

}

