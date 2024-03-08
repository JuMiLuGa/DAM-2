package model.config.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import utils.ANSI;

public class JsonFileHandler implements FileHandler {
    static final String filename = "config.json";

    public FileData read() throws Exception {
        ANSI.printYellow("JsonFileHandler.read()");
        FileReader reader = new FileReader("config.json");
        FileData data = (FileData)(new Gson()).fromJson(reader, FileData.class);
        ANSI.printYellow("JSON READ OK");
        return data;
    }

    public void write(FileData data) throws Exception {
        ANSI.printYellow("JsonFileHandler.write()");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder = gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        FileWriter writer = new FileWriter("config.json");
        ANSI.printYellow("Writing....");
        gson.toJson(data, writer);
        writer.close();
        ANSI.printYellow("JSON WRITE OK");
    }
}

