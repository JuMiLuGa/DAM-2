package model;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XML {

    private Session session;

    public static void exportarXML(User user, File file){

        String name = user.getName();
        String hash = user.getPasswordHash();
        String age = user.getAge();
        String mail = user.getEmail();

        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xmlBuilder.append("<user>");
        xmlBuilder.append("<name>").append(name).append("</name>");
        xmlBuilder.append("<passwordHash>").append(hash).append("</passwordHash>");
        xmlBuilder.append("<age>").append(age).append("</age>");
        xmlBuilder.append("<email>").append(mail).append("</email>");
        xmlBuilder.append("</user>");



        try {

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(xmlBuilder.toString());


            bufferedWriter.close();

            System.out.println("El archivo XML fue creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
