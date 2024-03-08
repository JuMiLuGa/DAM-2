package services.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import utils.ANSI;

public class JSON {
    public static void exportFile(String path, JSONData data) throws Exception {
        ANSI.printCyan("JSON.exportFile()");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder = gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        FileWriter writer = new FileWriter(path);
        gson.toJson(data, writer);
        writer.close();
    }

    public static JSONData importFile(String path) throws Exception {
        ANSI.printCyan("JSON.importFile()");
        Gson gson = new Gson();
        FileReader reader = new FileReader(path);
        JSONData data = (JSONData)gson.fromJson(reader, JSONData.class);
        return data;
    }
}
