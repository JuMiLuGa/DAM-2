package model;

import gui.UserDetails;
import org.mindrot.jbcrypt.BCrypt;

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
                System.out.println("sesion iniciada");
                session.setUser(users.getUserByUsername(nombreUsuario));
                return true;
            }
        }
        System.out.println("sesion no iniciada");
        return false;
    }
    public void verDetallesUsuario() {

        String name = session.getUser().getName();
        String age = session.getUser().getAge();
        String email = session.getUser().getEmail();

        UserDetails userDetailsWindow = new UserDetails(this, name, age, email);
        userDetailsWindow.setVisible(true);
    }
}
