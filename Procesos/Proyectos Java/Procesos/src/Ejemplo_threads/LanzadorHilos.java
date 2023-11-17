package Ejemplo_threads;



public class LanzadorHilos {
    public static void main(String[] args) {
        int NUM_HILOS=100;
        Thread[] hilosAsociados;

        hilosAsociados=new Thread[NUM_HILOS];
        for (int i=0;i<NUM_HILOS;i++){
            TareaCompleja t=new TareaCompleja();
            Thread hilo=new Thread(t);
            hilo.setName(String.valueOf(i));

            hilo.start();
            System.out.println(
                    "Comenzado el hilo"+hilo.getName());
            hilosAsociados[i]=hilo;
        }

        for (int i=0; i<NUM_HILOS; i++){
            Thread hilo=hilosAsociados[i];
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.print("Algun hilo acabó ");
                System.out.println(" antes de tiempo!");
            }
        }
        System.out.println("El principal ha terminado");
    }
}