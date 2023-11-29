package clock;

/**
 * Imports clase AlarmEvent
 */
import java.util.EventObject;

/**
 * Representa un evento de alarma. Extiende la clase EventObject y se utiliza para notificar
 * a los objetos que escuchan eventos de alarma cuando ocurre una acción relacionada con la alarma.
 * 
 * @author DAM2_Alu10
 */

public class AlarmEvent extends EventObject {

    /**
     * Constructor de la clase AlarmEvent.
     *
     * @param source Objeto que desencadenó el evento.
     */
    
    public AlarmEvent(Object source) {
        super(source);
    }

}
