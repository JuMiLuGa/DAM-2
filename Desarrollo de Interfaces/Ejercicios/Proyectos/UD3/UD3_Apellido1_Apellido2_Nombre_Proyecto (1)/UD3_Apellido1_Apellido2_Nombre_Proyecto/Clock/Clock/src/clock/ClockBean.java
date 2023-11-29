package clock;

/**
 * Imports clase ClockBean
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * La clase ClockBean es un componente visual que actúa como un reloj digital. Hereda de JLabel,
 * implementa la interfaz ActionListener y es serializable. Puede mostrar la hora actual y gestionar
 * una alarma que, cuando se activa, notifica a los objetos que escuchan eventos de alarma.
 * 
 * @author DAM2_Alu10
 */

public class ClockBean extends JLabel implements ActionListener, Serializable {

    /**
     * Determina si se usa el modo 12 horas o el 24 horas
     */
    public boolean mode24;
    
    /**
     * Indica si la alarma esta activada o desactivada
     */
    public boolean enableAlarm;
    
    /**
     * Indica los minutos para la alarma
     */
    public int minutesAlarm;
    
    /**
     * Indica las horas para la alarma
     */
    public int hourAlarm;
    private final Timer t;
    private Calendar calendar;
    private IAlarmListener receptor;
    private String message;
    private final String[] hours = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    private final String[] minutes = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
    private final String[] seconds = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
    private final String[] AMPM = {"AM", "PM"};

    /**
     * Obtiene el mensaje asociado al reloj.
     *
     * @return El mensaje asociado al reloj.
     */
    
    public String getMessage() {
        return message;
    }

    /**
     * Establece el mensaje asociado al reloj.
     *
     * @param message El nuevo mensaje asociado al reloj.
     */
    
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Verifica si la alarma está habilitada.
     *
     * @return True si la alarma está habilitada, false en caso contrario.
     */
    
    public boolean isEnableAlarm() {
        return enableAlarm;
    }

    /**
     * Establece el estado de habilitación de la alarma.
     *
     * @param enableAlarm True para habilitar la alarma, false para deshabilitarla.
     */
    
    public void setEnableAlarm(boolean enableAlarm) {
        this.enableAlarm = enableAlarm;
    }

    /**
     * Obtiene los minutos de la alarma.
     *
     * @return Los minutos de la alarma.
     */
    
    public int getMinutesAlarm() {
        return minutesAlarm;
    }

    /**
     * Establece los minutos de la alarma.
     *
     * @param minutesAlarm Los nuevos minutos de la alarma.
     */
    
    public void setMinutesAlarm(int minutesAlarm) {
        this.minutesAlarm = minutesAlarm;
    }

    /**
     * Obtiene la hora de la alarma.
     *
     * @return La hora de la alarma.
     */
    
    public int getHourAlarm() {
        return hourAlarm;
    }

    /**
     * Establece la hora de la alarma.
     *
     * @param hourAlarm La nueva hora de la alarma.
     */
    
    public void setHourAlarm(int hourAlarm) {
        this.hourAlarm = hourAlarm;
    }

    /**
     * Verifica si el reloj está en modo de 24 horas.
     *
     * @return True si el reloj está en modo de 24 horas, false en caso contrario.
     */
    
    public boolean isMode24() {
        return mode24;
    }

    /**
     * Establece el modo de 24 horas del reloj.
     *
     * @param mode24 True para activar el modo de 24 horas, false para desactivarlo.
     */
    
    public void setMode24(boolean mode24) {
        this.mode24 = mode24;
    }

    /**
     * Constructor de la clase ClockBean. Inicializa el temporizador y configura la hora inicial.
     */

    
    public ClockBean() {
        this.setHorizontalAlignment(SwingConstants.RIGHT);
        message = "";
        mode24 = true;
        enableAlarm = false;
        t = new Timer(1000, this);
        t.start();
        calendar = Calendar.getInstance();

        String h = hours[calendar.get(Calendar.HOUR_OF_DAY)];
        String m = minutes[calendar.get(Calendar.MINUTE)];
        String s = seconds[calendar.get(Calendar.SECOND)];
        String AM_PM = AMPM[calendar.get(Calendar.AM_PM)];
        setText(h + ":" + m + ":" + s + " " + AM_PM);
    }

    /**
     * Maneja el evento de temporizador y actualiza la hora en la etiqueta del reloj.
     *
     * @param e Evento de acción.
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String h;
        String m;
        String s;
        String AM_PM;
        calendar = Calendar.getInstance();

        if (isMode24()) {
            h = hours[calendar.get(Calendar.HOUR_OF_DAY)];
            m = minutes[calendar.get(Calendar.MINUTE)];
            s = seconds[calendar.get(Calendar.SECOND)];
            setText(h + ":" + m + ":" + s);
        } else {
            h = hours[calendar.get(Calendar.HOUR)];
            m = minutes[calendar.get(Calendar.MINUTE)];
            s = seconds[calendar.get(Calendar.SECOND)];
            AM_PM = AMPM[calendar.get(Calendar.AM_PM)];
            setText(h + ":" + m + ":" + s + " " + AM_PM);
        }
        repaint();

        if (enableAlarm) {
            if ((Integer.parseInt(h) == hourAlarm) && (Integer.parseInt(m) == minutesAlarm)) {
                receptor.captureAlarm(new AlarmEvent(this));
            }
        }
    }

    /**
     * Agrega un objeto que escucha eventos de alarma.
     *
     * @param receptor Objeto que implementa la interfaz IAlarmListener.
     */
    
    public void addAlarmListener(IAlarmListener receptor) {
        this.receptor = receptor;
    }

    /**
     * Elimina un objeto que escucha eventos de alarma.
     *
     * @param receptor Objeto que implementa la interfaz IAlarmListener.
     */
    
    public void removeAlarmListener(IAlarmListener receptor) {
        this.receptor = null;
    }
}
