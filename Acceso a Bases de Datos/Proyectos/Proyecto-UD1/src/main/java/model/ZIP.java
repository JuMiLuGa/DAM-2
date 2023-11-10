package model;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class ZIP {

    public static void exportarZIP(App app, File zipFile) throws ParserConfigurationException {
        File directory = new File(zipFile.getParent(), "users");
        app.exportAllUsersXML(directory);
        app.exportAllUsersJSON(directory);

    }
}

