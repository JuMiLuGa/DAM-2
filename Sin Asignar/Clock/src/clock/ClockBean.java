/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ClockBean extends JLabel implements ActionListener, Serializable {

    public boolean mode24;
    public boolean enableAlarm;
    public int minutesAlarm;
    public int hourAlarm;
    private final Timer t;
    private Calendar calendar;
    private IAlarmListener receptor;
    private String message;
    private final String[] hours = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    private final String[] minutes = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
    private final String[] seconds = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
    private final String[] AMPM = {"AM", "PM"};

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isEnableAlarm() {
        return enableAlarm;
    }

    public void setEnableAlarm(boolean enableAlarm) {
        this.enableAlarm = enableAlarm;
    }

    public int getMinutesAlarm() {
        return minutesAlarm;
    }

    public void setMinutesAlarm(int minutesAlarm) {
        this.minutesAlarm = minutesAlarm;
    }

    public int getHourAlarm() {
        return hourAlarm;
    }

    public void setHourAlarm(int hourAlarm) {
        this.hourAlarm = hourAlarm;
    }

    public boolean isMode24() {
        return mode24;
    }

    public void setMode24(boolean mode24) {
        this.mode24 = mode24;
    }

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

    public void addAlarmListener(IAlarmListener receptor) {
        this.receptor = receptor;
    }

    public void removeAlarmListener(IAlarmListener receptor) {
        this.receptor = null;
    }
}
