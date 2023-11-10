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


        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("user");
        doc.appendChild(rootElement);


        addElement(doc, rootElement, "name", name);
        addElement(doc, rootElement, "passwdHash", passwdHash);
        addElement(doc, rootElement, "age", age);
        addElement(doc, rootElement, "email", mail);


        try (FileOutputStream output = new FileOutputStream(file)) {
            writeXml(doc, output);
            System.out.println("El archivo se ha exportado correctamente");
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void exportarXML(Users users, File directory) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        try {
            if (!directory.exists()) {
                directory.mkdirs();
            }

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("users");
            doc.appendChild(rootElement);

            for (User user : users.devolverLista()) {
                String name = user.getName();
                String passwdHash = user.getPasswordHash();
                String age = user.getAge();
                String mail = user.getEmail();

                Element userElement = doc.createElement("user");
                rootElement.appendChild(userElement);

                addElement(doc, userElement, "name", name);
                addElement(doc, userElement, "passwdHash", passwdHash);
                addElement(doc, userElement, "age", age);
                addElement(doc, userElement, "email", mail);
            }

            File file = new File(directory, "users.xml");
            try (FileOutputStream output = new FileOutputStream(file)) {
                writeXml(doc, output);
            }

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
}