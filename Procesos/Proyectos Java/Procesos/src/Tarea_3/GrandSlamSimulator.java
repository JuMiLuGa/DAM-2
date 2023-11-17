package Tarea_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GrandSlamSimulator {
    public static void main(String[] args) {
        Player[] players = new Player[32];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Jugador" + (i + 1));
        }

        // Crear el archivo de log
        String logFilePath = "logT3.txt";

        // Simulamos los partidos de los 16vos de final y escribimos en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath))) {
            Game[] games = new Game[16];
            for (int i = 0; i < games.length; i++) {
                games[i] = new Game(players[i], players[players.length - 1 - i], writer);
                games[i].start();
            }

            // Esperar a que todos los partidos terminen
            for (Game game : games) {
                try {
                    game.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            writer.write("Fin de los 16vos de final\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}