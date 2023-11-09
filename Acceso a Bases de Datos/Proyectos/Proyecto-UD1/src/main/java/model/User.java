package model;

import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String passwordHash; //La contraseña debe ser el Hash
    private String age;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = BCrypt.hashpw(passwordHash, BCrypt.gensalt());
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, String password, String age, String email) {
        //Inicializar los atributos con los valores adecuados
        this.name = name;
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt()); //La contraseña debe ser el Hash
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}

