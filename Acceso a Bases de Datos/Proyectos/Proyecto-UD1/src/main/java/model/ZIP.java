package model;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIP {

    public static void exportarZIP(App app, File zipFile) throws ParserConfigurationException, IOException {
        File directory = new File(zipFile.getParent(), "users");
        app.exportAllUsersXML(directory);
        app.exportAllUsersJSON(directory);

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            comprimirDirectorio(directory, "Users", zipOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        deleteDirectory(Paths.get(directory.getAbsolutePath()));
    }

    public static void comprimirDirectorio(File directorio, String nombreBase, ZipOutputStream zipOut) throws IOException {
        File[] archivos = directorio.listFiles();

        for (File archivo : archivos) {
            if (archivo.isDirectory()) {
                comprimirDirectorio(archivo, nombreBase + File.separator + archivo.getName(), zipOut);
            } else {
                FileInputStream fis = new FileInputStream(archivo);
                ZipEntry zipEntry = new ZipEntry(nombreBase + File.separator + archivo.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zipOut.write(buffer, 0, len);
                }

                fis.close();
            }
        }
    }

    public static void deleteDirectory(Path directory) throws IOException
    {
        if (Files.exists(directory))
        {
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>()
            {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attr)
                        throws IOException
                {
                    Files.delete(path);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path path, IOException ex)
                        throws IOException
                {
                    Files.delete(path);
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }
}

