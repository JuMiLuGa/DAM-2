package Ejercicio_112;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LeerPeliculasXML {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File xmlFile = new File("peliculas.xml");
            Document document = builder.parse(xmlFile);

            NodeList peliculas = document.getElementsByTagName("pelicula");

            System.out.println("Se va a mostrar la información de " + peliculas.getLength() + " películas.");

            for (int i = 0; i < peliculas.getLength(); i++) {
                Element pelicula = (Element) peliculas.item(i);
                String titulo = pelicula.getElementsByTagName("titulo").item(0).getTextContent();
                String ano = pelicula.getElementsByTagName("ano").item(0).getTextContent();
                String precio = pelicula.getElementsByTagName("precio").item(0).getTextContent();

                System.out.println("\nPELÍCULA #" + (i + 1) + ":");
                System.out.println("Título: " + titulo);
                System.out.println("Año: " + ano);
                System.out.println("Precio: " + precio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

