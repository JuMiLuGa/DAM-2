package Ejercicio_203;

class Tarea {
    private int id;
    private String descripcion;
    private EstadoTarea estado;
    private String fechaCreacion;

    public Tarea(int id, String descripcion, EstadoTarea estado, String fechaCreacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }
}
