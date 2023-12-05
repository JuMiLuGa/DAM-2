package UD3.Ejercicio1;

public class Pelicula {
    // Atributos
    private String titulo;
    private String director;
    private String codigo;
    private int añoEstreno;

    // Constructor
    public Pelicula(String titulo, String director, String codigo, int añoEstreno) {
        this.titulo = titulo;
        this.director = director;
        this.codigo = codigo;
        this.añoEstreno = añoEstreno;
    }

    // Métodos get y set para cada atributo
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getAñoEstreno() {
        return añoEstreno;
    }

    public void setAñoEstreno(int añoEstreno) {
        this.añoEstreno = añoEstreno;
    }

    // Método toString
    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", codigo='" + codigo + '\'' +
                ", año de estreno=" + añoEstreno +
                '}';
    }
}
