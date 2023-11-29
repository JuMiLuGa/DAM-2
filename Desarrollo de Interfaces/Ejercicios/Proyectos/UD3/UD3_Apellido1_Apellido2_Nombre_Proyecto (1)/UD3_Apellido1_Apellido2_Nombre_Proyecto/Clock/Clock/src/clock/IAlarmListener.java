package clock;

/**
 * Imports Clase IAlarmListener
 */
import java.util.EventListener;

    /**
    * Interfaz que define el contrato para los objetos que desean recibir notificaciones cuando se activa
    * la alarma en el reloj (ClockBean). Los objetos que implementan esta interfaz deben proporcionar la
    * lógica necesaria para manejar el evento de alarma.
    * 
    * @author DAM2_Alu10
    */

public interface IAlarmListener extends EventListener {

    /**
     * Método llamado cuando se captura un evento de alarma.
     *
     * @param ev Evento de alarma capturado.
     */
    
    public void captureAlarm(AlarmEvent ev);
}
