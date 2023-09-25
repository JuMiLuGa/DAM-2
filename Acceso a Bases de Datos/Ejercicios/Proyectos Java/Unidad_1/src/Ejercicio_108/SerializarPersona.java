package Ejercicio_108;

import java.io.*;

class SerializarPersona {
    public void escribirPersonaEnFichero(Persona persona, File fichero) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(persona);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Persona leerPersonaDeFichero(File fichero) {
        Persona persona = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            persona = (Persona) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return persona;
    }
}