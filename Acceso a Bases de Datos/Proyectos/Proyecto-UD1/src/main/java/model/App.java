package model;

import gui.*;
import org.mindrot.jbcrypt.BCrypt;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;

    private FileHandler fileHandler;


    public App() throws IOException {
        session = new Session();
        fileHandler = new FileHandler(filename);
        users = fileHandler.load();
        this.verLogin();
    }

    public void verLogin(){
        Login loginWindow = new Login(this);
        loginWindow.setVisible(true);
    }

    public boolean iniciarSesion(String nombreUsuario, String contrasena) throws IOException {
        if (users.userExists(nombreUsuario)) {
            User usuario = users.getUserByUsername(nombreUsuario);
            String hashAlmacenado = usuario.getPasswordHash();

            if (BCrypt.checkpw(contrasena, hashAlmacenado)) {
                session.setUser(users.getUserByUsername(nombreUsuario));
                session.archivoLog("LOGIN");
                return true;

            }
        }

        return false;
    }

    public void verUser(){
        gui.User userWindow = new gui.User(this, session.getUser().getName());
        userWindow.setVisible(true);
    }

    public void verDetallesUsuario() {

        String name = session.getUser().getName();
        String age = session.getUser().getAge();
        String email = session.getUser().getEmail();

        UserDetails userDetailsWindow = new UserDetails(this, name, age, email);
        userDetailsWindow.setVisible(true);
    }

    public void exportarXML(File file) throws ParserConfigurationException {

        XML.exportarActualXML(session.getUser(), file);
    }

    public void exportarJSON(File file) {

        JSON.exportarJSON(session.getUser(), file);
    }

    public void changePasswd(String text) {
        session.getUser().setPasswordHash(text);
        fileHandler.saveUsers(users);
    }

    public void changePasswdWindow() {
        UserChangePassword changePasswordWindow = new UserChangePassword(this, session.getUser().getName());
        changePasswordWindow.setVisible(true);
    }

    public void crearNuevoUsuario() {
        UserCreate userCreateWindow = new UserCreate(this);
        userCreateWindow.setVisible(true);
    }

    public void guardarUsuario(String name, String passwd, String age, String mail) {
        User newUser = new  User(name,passwd,age,mail);
        users.addUser(newUser);
        fileHandler.saveUsers(users);
    }

    public void borrarUsuario(){
        UserDelete userDeleteWindow = new UserDelete(this, session.getUser().getName());
        userDeleteWindow.setVisible(true);
    }

    public void borrarUsuarioLista(){
        users.deleteUser(session.getUser().getName());
        fileHandler.saveUsers(users);
    }

    public void cerrarSesion() throws IOException {
        Login loginWindow = new Login(this);
        loginWindow.setVisible(true);
        session.archivoLog("LOGOUT");
        session.setUser(null);
    }

    public void exportAllUsersXML(File file) throws ParserConfigurationException {
        XML.exportarXML(users, file);
    }

    public void exportAllUsersJSON(File file){
        JSON.exportarTodosJSON(users, file);
    }
    public void exportarZIP(File file) throws ParserConfigurationException, IOException {
        ZIP.exportarZIP(this, file);
    }
}

