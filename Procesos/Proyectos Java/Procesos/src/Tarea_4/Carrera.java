package Tarea_4;

class Carrera {

    public static final int NUM_COCHES = 10;
    public static final int NUM_CHECKPOINTS = 6;
    public static final int MIN_TIEMPO = 1000;
    public static final int MAX_TIEMPO = 1100;

    public static int[][] tiempos = new int[NUM_COCHES][NUM_CHECKPOINTS];
    public static int[] tiemposTotales = new int[NUM_COCHES];

    public synchronized static void registrarTiempo(int coche, int checkpoint, int tiempo) {
        tiempos[coche][checkpoint] = tiempo;
        tiemposTotales[coche] += tiempo;

        System.out.println("Coche " + coche + " ha pasado el checkpoint " + checkpoint +
                " con un tiempo de " + tiempo + " ms. Tiempo total: " + tiemposTotales[coche] + " ms.");
    }
}
