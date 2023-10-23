package model;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private Map<String, User> userMap;

    public Users() {
        userMap = new HashMap<>();
    }

    // Agregar un usuario al mapa de usuarios
    public void addUser(String username, User user) {
        userMap.put(username, user);
    }

    // Obtener un usuario por nombre de usuario
    public User getUserByUsername(String username) {
        return userMap.get(username);
    }

    // Verificar si un usuario existe por nombre de usuario
    public boolean userExists(String username) {
        return userMap.containsKey(username);
    }

    // Obtener todos los usuarios en una colección
    public Map<String, User> getAllUsers() {
        return userMap;
    }
}
