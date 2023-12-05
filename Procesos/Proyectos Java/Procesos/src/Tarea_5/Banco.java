package Tarea_5;

import java.io.PrintStream;

class Banco {
    private int saldo = 0;

    private PrintStream logStream;

    public Banco(PrintStream logStream) {
        this.logStream = logStream;
    }

    public synchronized void depositar(int cantidad) {
        saldo += cantidad;
        log("Depósito de " + cantidad + " realizado. Saldo actual: " + saldo);
    }

    public synchronized void retirar(int cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            log("Retiro de " + cantidad + " realizado. Saldo actual: " + saldo);
        } else {
            log("No hay suficiente saldo para el retiro de " + cantidad);
        }
    }

    public synchronized int balance() {
        return saldo;
    }

    private void log(String message) {
        logStream.println(message);
    }
}
