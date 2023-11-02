package model;

import gui.UserChangePassword;
import gui.UserDetails;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;


    public App() {
        users = new Users();
        // Inicializa y agrega usuarios a la colección Users.

        session = new Session();

    }


    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        if (users.userExists(nombreUsuario)) {
            User usuario = users.getUserByUsername(nombreUsuario);
            String hashAlmacenado = usuario.getPasswordHash();

            if (BCrypt.checkpw(contrasena, hashAlmacenado)) {
                session.setUser(users.getUserByUsername(nombreUsuario));
                return true;
            }
        }

        return false;
    }
    public void verDetallesUsuario() {

        String name = session.getUser().getName();
        String age = session.getUser().getAge();
        String email = session.getUser().getEmail();

        UserDetails userDetailsWindow = new UserDetails(this, name, age, email);
        userDetailsWindow.setVisible(true);
    }

    public void exportarXML(File file) {
        XML.exportarXML(session.getUser(),file);
    }

    public void exportarJSON(File file) {
        JSON.exportarJSON(session.getUser(),file);
    }

    public void changePasswd(String text) {

    }

    public void changePasswdWindow() {
        UserChangePassword changePasswordWindow = new UserChangePassword(this, session.getUser().getName());
        changePasswordWindow.setVisible(true);
    }
}
