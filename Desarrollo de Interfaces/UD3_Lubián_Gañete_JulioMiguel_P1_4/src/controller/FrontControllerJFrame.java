/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import clock.AlarmEvent;
import clock.IAlarmListener;
import controller.clock.ClockController;
import controller.manageAldData.ManageAldDataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.aldComputerService.AldComputerService;
import view.MainJFrame;
import view.aldComputerService.ManageAldDataDialog;
import view.clock.ClockConfigurationDialog;

/**
 *
 * @author Lubián_Gañete_Julio_Miguel
 */

public class FrontControllerJFrame {

    private MainJFrame view;
    private AldComputerService model;
    
    public FrontControllerJFrame(MainJFrame view, AldComputerService model) {
        this.view = view;
        this.model = model;
        this.view.setQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.setManageDataMenuItemListener(setManageDataItemActionListener());
        this.view.addNotificationMenuItemListener(getNotificationMenuItemItemListener());
        this.view.addAlarmListener(this.setClockBeanAlarmListener());
    }

    private ActionListener setQuitMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                System.exit(0);
            }
        };
        return al;
    }

    private ActionListener setManageDataItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageAldDataDialog mad = new ManageAldDataDialog(view, true);
                ManageAldDataController madc = new ManageAldDataController(mad, model);
                mad.setVisible(true);
            }
        };
        return al;
    }

    private ActionListener getNotificationMenuItemItemListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClockConfigurationDialog ccd = new ClockConfigurationDialog(view, true);
                ClockController cc = new ClockController(view, ccd);
                ccd.setVisible(true);
            }
        };
        return al;
    }
    
        private IAlarmListener setClockBeanAlarmListener() {
        IAlarmListener listener = new IAlarmListener() {
            @Override
            public void captureAlarm(AlarmEvent ev) {
                view.setEnableAlarm(false);
                view.removeAlarm(this);
                JOptionPane.showMessageDialog(view, view.getAlarmMessage(),
                        "ALARM!", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        return listener;
    }
}
