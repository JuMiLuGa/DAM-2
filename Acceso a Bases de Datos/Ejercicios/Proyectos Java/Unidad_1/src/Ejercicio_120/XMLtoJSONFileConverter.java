package Ejercicio_120;

import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class XMLtoJSONFileConverter {

    public static void main(String[] args) {
        try {
            // Ruta al archivo XML de entrada
            String xmlFilePath = "bookstore.xml";

            // Ruta para guardar el archivo JSON de salida
            String jsonFilePath = "bookstore.json";

            // Leer el contenido del archivo XML
            String xmlContent = readXMLFile(xmlFilePath);

            // Parsear el XML a un objeto JSONObject
            JSONObject jsonObject = XML.toJSONObject(xmlContent);

            // Escribir el objeto JSON en un archivo
            writeJSONFile(jsonFilePath, jsonObject.toString(2));

            System.out.println("Conversión de XML a JSON completada y guardada en " + jsonFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Función para leer un archivo XML y retornar su contenido como una cadena
    private static String readXMLFile(String filePath) throws Exception {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    // Función para escribir un archivo JSON
    private static void writeJSONFile(String filePath, String jsonContent) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(jsonContent);
        }
    }
}


