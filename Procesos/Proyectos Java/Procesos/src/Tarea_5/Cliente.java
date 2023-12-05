package Tarea_5;

import java.util.Random;

class Cliente implements Runnable {
    private Banco banco;
    private Random random = new Random();

    public Cliente(Banco banco) {
        this.banco = banco;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int cantidad = random.nextInt(100) + 1;
            banco.depositar(cantidad);

            cantidad = random.nextInt(50) + 1;
            banco.retirar(cantidad);
        }
    }
}