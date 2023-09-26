package Ejercicio_115;

import java.io.Serializable;

class Producto implements Serializable {
    private int idProducto;
    private String descripcion;
    private double precio;

    public Producto(int idProducto, String descripcion, double precio) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "ID: " + idProducto + ", Descripción: " + descripcion + ", Precio: " + precio;
    }
}