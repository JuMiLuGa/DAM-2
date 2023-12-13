/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import clock.AlarmEvent;
import clock.IAlarmListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainJFrame;


/**
 *
 * @author fermigo
 */
public class FrontControllerJFrame implements IAlarmListener {

    private final MainJFrame view;

    public FrontControllerJFrame(MainJFrame view) {
        this.view = view;
        this.view.setQuitMenuItemListener(this.getQuitMenuItemActionListener());
    }

    private ActionListener getQuitMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    }

    @Override
    public void captureAlarm(AlarmEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
