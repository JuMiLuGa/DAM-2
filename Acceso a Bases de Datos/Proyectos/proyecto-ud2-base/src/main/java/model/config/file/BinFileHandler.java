package model.config.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import utils.ANSI;

public class BinFileHandler implements FileHandler {
    static final String filename = "config.bin";

    public FileData read() throws Exception {
        ANSI.printYellow("BinFileHandler.read()");
        FileInputStream stream = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(stream);
        FileData data = (FileData)in.readObject();
        in.close();
        stream.close();
        ANSI.printYellow("BIN READ OK");
        return data;
    }

    public void write(FileData data) throws Exception {
        ANSI.printYellow("BinFileHandler.write()");
        System.out.println(data);
        FileOutputStream stream = new FileOutputStream("config.bin");
        ObjectOutputStream out = new ObjectOutputStream(stream);
        out.writeObject(data);
        out.flush();
        out.close();
        stream.close();
        ANSI.printYellow("BIN WRITE OK");
    }
}

