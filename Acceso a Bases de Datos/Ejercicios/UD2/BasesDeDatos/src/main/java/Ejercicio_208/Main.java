package Ejercicio_208;

import com.fasterxml.jackson.core.*;

import javax.xml.stream.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            createTables(connection);

            Scanner scanner = new Scanner(System.in);
            int option;
            do {
                mostrarMenu();
                System.out.print("Seleccione una opción: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        cargarDatosDesdeJSON();
                        break;
                    case 2:
                        agregarCancion();
                        break;
                    case 3:
                        agregarUsuario();
                        break;
                    case 4:
                        crearListaReproduccion();
                        break;
                    case 5:
                        agregarCancionALista();
                        break;
                    case 6:
                        eliminarListaReproduccion();
                        break;
                    case 7:
                        mostrarInformacion();
                        break;
                    case 8:
                        exportarAXML();
                        break;
                    case 9:
                        System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                        break;
                }
            } while (option != 9);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void createTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS canciones (" +
                    "id INTEGER PRIMARY KEY," +
                    "titulo VARCHAR," +
                    "artista VARCHAR," +
                    "duracion INTEGER," +
                    "anio INTEGER)");

            statement.execute("CREATE TABLE IF NOT EXISTS usuarios (" +
                    "id INTEGER PRIMARY KEY," +
                    "nombre_usuario VARCHAR UNIQUE," +
                    "nombre VARCHAR," +
                    "correo VARCHAR)");

            statement.execute("CREATE TABLE IF NOT EXISTS listas_reproduccion (" +
                    "id INTEGER PRIMARY KEY," +
                    "nombre_lista VARCHAR," +
                    "id_usuario INTEGER REFERENCES usuarios(id))");

            statement.execute("CREATE TABLE IF NOT EXISTS canciones_listas (" +
                    "id INTEGER PRIMARY KEY," +
                    "id_cancion INTEGER REFERENCES canciones(id)," +
                    "id_lista_reproduccion INTEGER REFERENCES listas_reproduccion(id))");
        }
    }


    private static void cargarDatosDesdeJSON() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db");
             FileReader fileReader = new FileReader("208.json");
             JsonParser jsonParser = new JsonFactory().createParser(fileReader)) {

            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("canciones".equals(fieldName)) {
                    jsonParser.nextToken();
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        String titulo = null, artista = null;
                        int duracion = 0, anio = 0;

                        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                            String field = jsonParser.getCurrentName();
                            jsonParser.nextToken();

                            switch (field) {
                                case "titulo":
                                    titulo = jsonParser.getText();
                                    break;
                                case "artista":
                                    artista = jsonParser.getText();
                                    break;
                                case "duracion":
                                    duracion = jsonParser.getIntValue();
                                    break;
                                case "anio":
                                    anio = jsonParser.getIntValue();
                                    break;
                            }
                        }

                        try (PreparedStatement preparedStatement = connection.prepareStatement(
                                "INSERT INTO canciones (titulo, artista, duracion, anio) VALUES (?, ?, ?, ?)")) {
                            preparedStatement.setString(1, titulo);
                            preparedStatement.setString(2, artista);
                            preparedStatement.setInt(3, duracion);
                            preparedStatement.setInt(4, anio);
                            preparedStatement.executeUpdate();
                        }
                    }
                } else if ("usuarios".equals(fieldName)) {
                    jsonParser.nextToken();
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        String nombreUsuario = null, nombre = null, correo = null;

                        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                            String field = jsonParser.getCurrentName();
                            jsonParser.nextToken();

                            switch (field) {
                                case "nombre_usuario":
                                    nombreUsuario = jsonParser.getText();
                                    break;
                                case "nombre":
                                    nombre = jsonParser.getText();
                                    break;
                                case "correo":
                                    correo = jsonParser.getText();
                                    break;
                            }
                        }

                        try (PreparedStatement preparedStatement = connection.prepareStatement(
                                "INSERT INTO usuarios (nombre_usuario, nombre, correo) VALUES (?, ?, ?)")) {
                            preparedStatement.setString(1, nombreUsuario);
                            preparedStatement.setString(2, nombre);
                            preparedStatement.setString(3, correo);
                            preparedStatement.executeUpdate();
                        }
                    }
                }
            }

            System.out.println("Datos cargados desde el archivo JSON y almacenados en la base de datos.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }


    private static void agregarCancion() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Título de la canción: ");
            String titulo = scanner.nextLine();

            System.out.print("Artista: ");
            String artista = scanner.nextLine();

            System.out.print("Duración (en segundos): ");
            int duracion = scanner.nextInt();

            System.out.print("Año de lanzamiento: ");
            int anio = scanner.nextInt();

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO canciones (titulo, artista, duracion, anio) VALUES (?, ?, ?, ?)")) {
                preparedStatement.setString(1, titulo);
                preparedStatement.setString(2, artista);
                preparedStatement.setInt(3, duracion);
                preparedStatement.setInt(4, anio);
                preparedStatement.executeUpdate();
                System.out.println("Canción agregada con éxito.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void agregarUsuario() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();

            System.out.print("Nombre real: ");
            String nombreReal = scanner.nextLine();

            System.out.print("Correo electrónico: ");
            String correo = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO usuarios (nombre_usuario, nombre, correo) VALUES (?, ?, ?)")) {
                preparedStatement.setString(1, nombreUsuario);
                preparedStatement.setString(2, nombreReal);
                preparedStatement.setString(3, correo);
                preparedStatement.executeUpdate();
                System.out.println("Usuario agregado con éxito.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void crearListaReproduccion() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nombre de la lista de reproducción: ");
            String nombreLista = scanner.nextLine();

            System.out.print("ID del usuario que crea la lista: ");
            int idUsuario = scanner.nextInt();

            if (usuarioExiste(idUsuario, connection)) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO listas_reproduccion (nombre_lista, id_usuario) VALUES (?, ?)")) {
                    preparedStatement.setString(1, nombreLista);
                    preparedStatement.setInt(2, idUsuario);
                    preparedStatement.executeUpdate();
                    System.out.println("Lista de reproducción creada con éxito.");
                }
            } else {
                System.out.println("El usuario con ID " + idUsuario + " no existe. No se pudo crear la lista.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void agregarCancionALista() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("ID de la lista de reproducción: ");
            int idListaReproduccion = scanner.nextInt();

            if (listaReproduccionExisteA(idListaReproduccion, connection)) {
                System.out.print("ID de la canción: ");
                int idCancion = scanner.nextInt();

                if (cancionExiste(idCancion, connection)) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(
                            "INSERT INTO canciones_listas (id_cancion, id_lista_reproduccion) VALUES (?, ?)")) {
                        preparedStatement.setInt(1, idCancion);
                        preparedStatement.setInt(2, idListaReproduccion);
                        preparedStatement.executeUpdate();
                        System.out.println("Canción agregada a la lista de reproducción con éxito.");
                    }
                } else {
                    System.out.println("La canción con ID " + idCancion + " no existe. No se pudo agregar a la lista.");
                }
            } else {
                System.out.println("La lista de reproducción con ID " + idListaReproduccion + " no existe. No se pudo agregar la canción.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void eliminarListaReproduccion() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("ID de la lista de reproducción a eliminar: ");
            int idListaReproduccion = scanner.nextInt();

            if (listaReproduccionExisteB(idListaReproduccion, connection)) {
                try (PreparedStatement deleteRelaciones = connection.prepareStatement(
                        "DELETE FROM canciones_listas WHERE id_lista_reproduccion = ?")) {
                    deleteRelaciones.setInt(1, idListaReproduccion);
                    deleteRelaciones.executeUpdate();

                    try (PreparedStatement deleteLista = connection.prepareStatement(
                            "DELETE FROM listas_reproduccion WHERE id = ?")) {
                        deleteLista.setInt(1, idListaReproduccion);
                        deleteLista.executeUpdate();
                        System.out.println("Lista de reproducción eliminada con éxito.");
                    }
                }
            } else {
                System.out.println("La lista de reproducción con ID " + idListaReproduccion + " no existe. No se pudo eliminar.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean listaReproduccionExisteB(int idListaReproduccion, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT 1 FROM listas_reproduccion WHERE id = ?")) {
            preparedStatement.setInt(1, idListaReproduccion);
            return preparedStatement.executeQuery().next();
        }
    }

    private static void mostrarInformacion() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            System.out.println("===== Información de Canciones =====");
            mostrarCanciones(connection);

            System.out.println("\n===== Información de Usuarios =====");
            mostrarUsuarios(connection);

            System.out.println("\n===== Información de Listas de Reproducción =====");
            mostrarListasReproduccion(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarCanciones(Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM canciones")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Título: " + resultSet.getString("titulo"));
                System.out.println("Artista: " + resultSet.getString("artista"));
                System.out.println("Duración: " + resultSet.getInt("duracion") + " segundos");
                System.out.println("Año de lanzamiento: " + resultSet.getInt("anio"));
                System.out.println("----------------------");
            }
        }
    }

    private static void mostrarUsuarios(Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM usuarios")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nombre de usuario: " + resultSet.getString("nombre_usuario"));
                System.out.println("Nombre real: " + resultSet.getString("nombre"));
                System.out.println("Correo electrónico: " + resultSet.getString("correo"));
                System.out.println("----------------------");
            }
        }
    }

    private static void mostrarListasReproduccion(Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM listas_reproduccion")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nombre de la lista: " + resultSet.getString("nombre_lista"));
                System.out.println("ID del usuario creador: " + resultSet.getInt("id_usuario"));
                System.out.println("----------------------");
            }
        }
    }

    private static void exportarAXML() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            exportarCancionesAXML(connection);

            exportarUsuariosAXML(connection);

            exportarListasReproduccionAXML(connection);

            System.out.println("Datos exportados a archivos XML con éxito.");

        } catch (SQLException | XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void exportarCancionesAXML(Connection connection) throws SQLException, XMLStreamException, IOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM canciones");
             ResultSet resultSet = preparedStatement.executeQuery();
             OutputStream outputStream = new FileOutputStream("canciones.xml")) {

            XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream);
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("canciones");

            while (resultSet.next()) {
                xmlStreamWriter.writeStartElement("cancion");
                xmlStreamWriter.writeAttribute("id", String.valueOf(resultSet.getInt("id")));
                escribirElemento(xmlStreamWriter, "titulo", resultSet.getString("titulo"));
                escribirElemento(xmlStreamWriter, "artista", resultSet.getString("artista"));
                escribirElemento(xmlStreamWriter, "duracion", String.valueOf(resultSet.getInt("duracion")));
                escribirElemento(xmlStreamWriter, "anio", String.valueOf(resultSet.getInt("anio")));
                xmlStreamWriter.writeEndElement();
            }

            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
        }
    }

    private static void exportarUsuariosAXML(Connection connection) throws SQLException, XMLStreamException, IOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM usuarios");
             ResultSet resultSet = preparedStatement.executeQuery();
             OutputStream outputStream = new FileOutputStream("usuarios.xml")) {

            XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream);
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("usuarios");

            while (resultSet.next()) {
                xmlStreamWriter.writeStartElement("usuario");
                xmlStreamWriter.writeAttribute("id", String.valueOf(resultSet.getInt("id")));
                escribirElemento(xmlStreamWriter, "nombre_usuario", resultSet.getString("nombre_usuario"));
                escribirElemento(xmlStreamWriter, "nombre", resultSet.getString("nombre"));
                escribirElemento(xmlStreamWriter, "correo", resultSet.getString("correo"));
                xmlStreamWriter.writeEndElement();
            }

            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
        }
    }

    private static void exportarListasReproduccionAXML(Connection connection) throws SQLException, XMLStreamException, IOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM listas_reproduccion");
             ResultSet resultSet = preparedStatement.executeQuery();
             OutputStream outputStream = new FileOutputStream("listas_reproduccion.xml")) {

            XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream);
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("listas_reproduccion");

            while (resultSet.next()) {
                xmlStreamWriter.writeStartElement("lista_reproduccion");
                xmlStreamWriter.writeAttribute("id", String.valueOf(resultSet.getInt("id")));
                escribirElemento(xmlStreamWriter, "nombre_lista", resultSet.getString("nombre_lista"));
                escribirElemento(xmlStreamWriter, "id_usuario", String.valueOf(resultSet.getInt("id_usuario")));
                xmlStreamWriter.writeEndElement();
            }

            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
        }
    }

    private static void escribirElemento(XMLStreamWriter xmlStreamWriter, String nombreElemento, String texto) throws XMLStreamException {
        xmlStreamWriter.writeStartElement(nombreElemento);
        xmlStreamWriter.writeCharacters(texto);
        xmlStreamWriter.writeEndElement();
    }

    private static boolean usuarioExiste(int idUsuario, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT 1 FROM usuarios WHERE id = ?")) {
            preparedStatement.setInt(1, idUsuario);
            return preparedStatement.executeQuery().next();
        }
    }

    private static boolean listaReproduccionExisteA(int idListaReproduccion, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT 1 FROM listas_reproduccion WHERE id = ?")) {
            preparedStatement.setInt(1, idListaReproduccion);
            return preparedStatement.executeQuery().next();
        }
    }

    private static boolean cancionExiste(int idCancion, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT 1 FROM canciones WHERE id = ?")) {
            preparedStatement.setInt(1, idCancion);
            return preparedStatement.executeQuery().next();
        }
    }

    private static void mostrarMenu() {
        System.out.println("===== Menú =====");
        System.out.println("1. Cargar datos desde JSON");
        System.out.println("2. Agregar nueva canción");
        System.out.println("3. Agregar nuevo usuario");
        System.out.println("4. Crear lista de reproducción");
        System.out.println("5. Agregar canción a lista de reproducción");
        System.out.println("6. Eliminar lista de reproducción");
        System.out.println("7. Mostrar información");
        System.out.println("8. Exportar a XML");
        System.out.println("9. Salir");
    }
}

