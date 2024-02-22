package model.entity;

public class Member {
    private String dni;

    private String name;

    private String email;

    public Member(String dni, String name, String email) {
        this.dni = dni;
        this.name = name;
        this.email = email;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isValid() {
        return (this.dni != null && !this.dni.isEmpty() && this.name != null &&
                !this.name.isEmpty() && this.email != null &&
                !this.email.isEmpty());
    }

    public String toString() {
        return "Member{dni=" + this.dni + ", name='" + this.name + "', email='" + this.email + "'}";
    }
}

