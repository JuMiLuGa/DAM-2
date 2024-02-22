package utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.config.database.Engine;

public class Util {
    public static void executeSQLFromTableName(Connection connection, Engine engine, String tableName) {
        ANSI.printPurpleBg("Util.executeEntitySQLFromFile()");
        try {
            String filePath = String.format("entity/%s/%s.sql", new Object[] { engine, tableName });
            ANSI.printYellow(filePath);
            String sql = getTextFromResource(filePath);
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTextFromResource(String filePath) throws Exception {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(filePath);
        StringBuilder textBuilder = new StringBuilder();
        Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        try {
            int c = 0;
            while ((c = reader.read()) != -1)
                textBuilder.append((char)c);
            reader.close();
        } catch (Throwable throwable) {
            try {
                reader.close();
            } catch (Throwable throwable1) {
                throwable.addSuppressed(throwable1);
            }
            throw throwable;
        }
        return textBuilder.toString();
    }

    public static String formatDate(Timestamp timestamp) {
        if (timestamp == null)
            return "";
        LocalDateTime datetime = timestamp.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        String str = datetime.format(formatter);
        return str;
    }

    public static void copyToClipBoard(String text) {
        ANSI.printPurpleBg("Util.copyToClipBoard()");
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}