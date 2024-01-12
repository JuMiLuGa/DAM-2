import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Game> games = loadGamesFromDirectory("./games");



        for (Game game : games){
            System.out.println(game.getId());
            System.out.println(game.getTitle());
            System.out.println(game.getPublisher());
            System.out.println(game.getYear());
        }


    }

    private static List<Game> loadGamesFromDirectory(String directoryPath){

        int addedGames = 0;

        List<Game> games = new ArrayList<>();
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null){
            for (File file : files){
                if (file.isFile() && file.getName().endsWith(".game")){
                    try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {

                        int header = dataInputStream.readInt();

                        if ((header & 0xFFFF0000) == 0xFF010000 || (header & 0xFFFF0000) == 0xFF000000) {
                            Game game = readGameFromFile(file);
                            if (game != null){


                                games.add(game);
                                addedGames++;
                            }
                        } else {
                            System.err.println("Archivo no valido: " + file.getName());
                        }

                    } catch (EOFException e){
                        System.err.println("Error al leer la cabecera en el archivo: "+ file.getName());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

        return games;
    }

    private static Game readGameFromFile(File file){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            return (Game) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e){
            System.err.println("Error al leer el objeto Game del archivo: "+ file.getName());
            e.printStackTrace();
        }
        return null;
    }

}