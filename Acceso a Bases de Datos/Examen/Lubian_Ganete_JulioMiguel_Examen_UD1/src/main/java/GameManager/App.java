package GameManager;

import java.util.List;

public class App {
    public static void main(String[] args){
        List<Game> games = Game.cargarJuegosDesdeFichero("import.txt");




        //Prueba para ver que esta leyendo los juegos

        for(Game game : games){
            System.out.println("Game ID: " + game.getId());
            System.out.println("Game Title: " + game.getTitle());
            System.out.println("Game ID: " + game.getPublisher());
            System.out.println("Game ID: " + game.getYear());
            System.out.println("-----------------------------------");


        }



    }
}

