package Tarea_3;

import java.io.BufferedWriter;
import java.io.IOException;
class Game extends Thread {
    private Player player1;
    private Player player2;
    private BufferedWriter writer;

    public Game(Player player1, Player player2, BufferedWriter writer) {
        this.player1 = player1;
        this.player2 = player2;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            writer.write("Inicio del partido entre " + player1.getName() + " y " + player2.getName() + "\n");
            // Simulación del partido con números aleatorios
            boolean player1Wins = Math.random() > 0.5;

            // Simulamos el tiempo que lleva el partido
            Thread.sleep(2000);

            // Imprimir el resultado del partido en el archivo
            if (player1Wins) {
                writer.write(player1.getName() + " gana el partido\n");
            } else {
                writer.write(player2.getName() + " gana el partido\n");
            }
            writer.flush();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}