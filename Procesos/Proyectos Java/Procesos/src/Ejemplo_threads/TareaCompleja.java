package Ejemplo_threads;

class TareaCompleja implements Runnable {
    @Override
    public void run() {
        // Obtener el hilo actual
        Thread hiloActual = Thread.currentThread();
        // Obtener el nombre del hilo
        String miNombre = hiloActual.getName();
        // Convertir el nombre del hilo a un número
        int n = Integer.parseInt(miNombre);

        // Verificar si el número es primo
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.println("El número " + n + " no es primo");
                break;
            }
            if (n - 1 == i) {
                System.out.println("El número " + n + " es primo");
                break;
            }
        }
        System.out.println(
                "Finalizado el hilo" + miNombre);
    }
}