package Ejercicio_120;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlToJsonConverter {
    public static void main(String[] args) {
        try {
            // Lee el archivo XML
            File xmlFile = new File("bookstore.xml"); // Reemplaza con el nombre de tu archivo XML de entrada
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Convierte el Document XML a un objeto JSON
            JSONObject json = convertToJson(doc.getDocumentElement());

            // Crea un objeto JSON raíz con el nombre "bookstore" (o el que desees)
            JSONObject root = new JSONObject();
            root.put("bookstore", json);

            // Guarda el JSON en un archivo de salida
            String jsonString = root.toString(4); // Indentación de 4 espacios
            File jsonFile = new File("output.json"); // Nombre del archivo JSON de salida
            // Escribe el JSON en el archivo de salida
            Files.write(Paths.get("bookstore.json"), jsonString.getBytes());

            System.out.println("Conversión completada. JSON almacenado en 'output.json'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject convertToJson(Element element) throws JSONException {
        JSONObject json = new JSONObject();
        NodeList childNodes = element.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);

            if (node instanceof Element) {
                // Si es un elemento, llamamos recursivamente a convertToJson
                Element childElement = (Element) node;
                String nodeName = childElement.getNodeName();

                if (json.has(nodeName)) {
                    // Si ya existe una clave con el mismo nombre, convertimos a JSONArray
                    Object existing = json.get(nodeName);
                    if (existing instanceof JSONArray) {
                        ((JSONArray) existing).put(convertToJson(childElement));
                    } else {
                        JSONArray jsonArray = new JSONArray();
                        jsonArray.put(existing);
                        jsonArray.put(convertToJson(childElement));
                        json.put(nodeName, jsonArray);
                    }
                } else {
                    json.put(nodeName, convertToJson(childElement));
                }
            } else if (node instanceof org.w3c.dom.Text) {
                // Si es un nodo de texto, lo añadimos como un valor en el JSON
                String text = ((org.w3c.dom.Text) node).getTextContent();
                json.put("text", text);
            }
        }

        return json;
    }
}
