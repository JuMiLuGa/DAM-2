package Tarea_4;

public class SimuladorCarrera {
    public static void main(String[] args) {
        Thread[] coches = new Thread[Carrera.NUM_COCHES];

        for (int i = 0; i < Carrera.NUM_COCHES; i++) {
            coches[i] = new Thread(new Coche(i));
        }

        System.out.println("¡Comienza la carrera!");
        for (int i = 0; i < Carrera.NUM_COCHES; i++) {
            coches[i].start();
        }

        try {
            for (int i = 0; i < Carrera.NUM_COCHES; i++) {
                coches[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("¡Carrera finalizada!");
    }
}
