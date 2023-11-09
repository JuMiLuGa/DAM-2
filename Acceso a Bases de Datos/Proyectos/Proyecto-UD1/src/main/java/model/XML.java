package model;

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

public class XML {

    private Session session;

    public static void exportarActualXML(User user, File file) throws ParserConfigurationException {

        String name = user.getName();
        String passwdHash = user.getPasswordHash();
        String age = user.getAge();
        String mail = user.getEmail();

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // Crear el elemento raíz
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("user");
        doc.appendChild(rootElement);

        // Agregar las variables como elementos al documento
        addElement(doc, rootElement, "name", name);
        addElement(doc, rootElement, "passwdHash", passwdHash);
        addElement(doc, rootElement, "age", age);
        addElement(doc, rootElement, "email", mail);

        // Escribir el documento XML al archivo proporcionado
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

    // Método para escribir el documento XML en un flujo de salida
    private static void writeXml(Document doc, OutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);


    }
}