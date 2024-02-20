package Ejercicio_203;

public class Main {
    public static void main(String[] args) {
        CrearBaseDatos crearBaseDatos = new CrearBaseDatos();
        crearBaseDatos.crearBaseDatos();

        CrearTabla crearTabla = new CrearTabla();
        crearTabla.crearTabla();

        CompletaTareas completaTareas = new CompletaTareas();
        completaTareas.insertarTareas();

        ConsultaTareas consultaTareas = new ConsultaTareas();
        System.out.println("----- Todas las tareas -----");
        consultaTareas.obtenerTodasLasTareas();
        System.out.println("\n----- Tareas después de 2024-01-24 -----");
        consultaTareas.obtenerTareasDespuesDeFecha("2024-01-24");
        System.out.println("\n----- Tareas en estado PENDIENTE -----");
        consultaTareas.obtenerTareasPorEstado("PENDIENTE");

        ModificacionTareas modificacionTareas = new ModificacionTareas();
        modificacionTareas.modificarDescripcionTarea(4, "Nueva descripción para Tarea 1");
        modificacionTareas.modificarEstadoTarea(4, "COMPLETADA");
        modificacionTareas.eliminarTarea(2);
        modificacionTareas.eliminarTareasCompletadas();

        LimpiarTabla limpiarTabla = new LimpiarTabla();
        limpiarTabla.limpiarTabla();
    }
}