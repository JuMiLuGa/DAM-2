package Ejercicio_3;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Formatter;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Main");
        FileHandler fileHandler;

        try {
            fileHandler = new FileHandler("log3.txt", true);
            logger.addHandler(fileHandler);

            Formatter customFormatter = new CustomLogFormatter();
            fileHandler.setFormatter(customFormatter);

            ProcesoA.main(args, fileHandler);
            ProcesoB.main(args, fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


