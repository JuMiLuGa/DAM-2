package GameManager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    // Atributos de juegos
    int id;
    String title;
    String publisher;
    int year;

    //Constructor atributos
    public Game(int id, String title, String publisher, int year) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }



    //INICIO GETTERS Y SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //FIN GETTERS Y SETTERS

    public static List<Game> cargarJuegosDesdeFichero(String fileName){
        List<Game> games = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null){
                if (line.startsWith("# GAME")){
                    boolean eliminado = line.contains("(X)");

                    if (!eliminado){
                        int id = Integer.parseInt(br.readLine().trim());
                        String title = br.readLine().trim();
                        String publisher = br.readLine().trim();
                        int year = Integer.parseInt(br.readLine().trim());

                        Game game = new Game(id,title,publisher,year);
                        games.add(game);
                    }


                }
            }
            } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(fileName);
        if (file.exists()){
            file.delete();
        }

        return games;
    }

/*
    public void guardarEnDirectorio(String dir){
        File gamesDirectory = new File(dir);
        if (gamesDirectory.exists()){
            deleteDirectory(gamesDirectory);
        }
        gamesDirectory.mkdir();

        for (Game game : getGames()){
            String textFileName = game.getId() + ".txt";
            String binaryFileName = game.getId() + ".game";

            try (PrintWriter textFileWriter = new PrintWriter(new FileWriter(new File(gamesDirectory,binaryFileName)))){

                textFileWriter.println("Title: " + game.getTitle());
                textFileWriter.println("Publisher: " + game.getPublisher());
                textFileWriter.println("Year: " + game.getYear());

            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    private List<Game> getGames(){
        return cargarJuegosDesdeFichero("import.txt");
    }

    private void deleteDirectory(File directory){
        File[] files = directory.listFiles();
        if(files != null){
            for (File file : files){
                if (file.isDirectory()){
                    deleteDirectory(file);
                }else{
                    file.delete();
                }
            }
        }
        directory.delete();
    }


    public static void exportarActualXML(Game game, File file) throws ParserConfigurationException {

        int id = game.getId();
        String title = game.getTitle();
        String publisher = game.getPublisher();
        int year = game.getYear();

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();


        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("user");
        doc.appendChild(rootElement);


        addElement(doc, rootElement, "id", String.valueOf(id));
        addElement(doc, rootElement, "title", title);
        addElement(doc, rootElement, "publisher", publisher);
        addElement(doc, rootElement, "year", String.valueOf(year));


        try (FileOutputStream output = new FileOutputStream(file)) {
            writeXml(doc, output);
            System.out.println("El archivo se ha exportado correctamente");
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void addElement(Document doc, Element rootElement, String nombre, String valor) {
        Element elemento = doc.createElement(nombre);
        elemento.appendChild(doc.createTextNode(valor));
        rootElement.appendChild(elemento);
    }

    private static void writeXml(Document doc, OutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);


    }

 */

}

