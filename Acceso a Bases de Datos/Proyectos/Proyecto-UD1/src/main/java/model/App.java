package model;

import org.mindrot.jbcrypt.BCrypt;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;


    public App() {
        users = new Users();
        // Inicializa y agrega usuarios a la colección Users.

        String nombre = "admin";
        String contrasenaPlana = "abc123.";
        int edad = 30;
        String correo = "admin@example.com";
        User usuario = new User(nombre, contrasenaPlana, edad, correo);
        users.addUser(nombre,usuario);
    }


    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        if (users.userExists(nombreUsuario)) {
            User usuario = users.getUserByUsername(nombreUsuario);
            String hashAlmacenado = usuario.getPasswordHash();

            System.out.println(usuario);
            System.out.println(contrasena);

            // Compara el hash de la contraseña ingresada con el hash almacenado en el usuario.
            if (BCrypt.checkpw(contrasena, hashAlmacenado)) {
                // Las contraseñas coinciden; el inicio de sesión es exitoso.
                System.out.println("sesion iniciada");
                return true;
            }
        }
        // Si no se encuentra el usuario o la contraseña es incorrecta, el inicio de sesión falla.
        System.out.println("sesion no iniciada");
        return false;
    }
}
