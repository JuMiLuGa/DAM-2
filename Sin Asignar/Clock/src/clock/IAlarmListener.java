/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clock;

import java.util.EventListener;

public interface IAlarmListener extends EventListener {

    public void captureAlarm(AlarmEvent ev);
}
