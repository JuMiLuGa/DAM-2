package Tarea_4;

import java.util.Random;

class Coche implements Runnable {
    private int numeroCoche;

    public Coche(int numeroCoche) {
        this.numeroCoche = numeroCoche;
    }

    @Override
    public void run() {
        for (int i = 0; i < Carrera.NUM_CHECKPOINTS; i++) {
            int tiempoTramo = generarTiempoAleatorio();
            try {
                Thread.sleep(tiempoTramo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Carrera.registrarTiempo(numeroCoche, i, tiempoTramo);
        }
    }

    private int generarTiempoAleatorio() {
        return new Random().nextInt((Carrera.MAX_TIEMPO - Carrera.MIN_TIEMPO) + 1) + Carrera.MIN_TIEMPO;
    }
}