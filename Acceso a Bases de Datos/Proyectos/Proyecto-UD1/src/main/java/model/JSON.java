package model;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSON {

        private Session session;

        public static void exportarJSON(User user, File file){

            Gson JSON = new GsonBuilder().setPrettyPrinting().create();
            String json = JSON.toJson(user);

            try {

                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(json);


                bufferedWriter.close();

                System.out.println("El archivo JSON fue creado correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


