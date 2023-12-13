/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import controller.manageAldComputers.ManageAldComputersController;
import controller.manageAldData.ManageAldDataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.aldComputerService.AldComputerService;
import view.MainJFrame;
import view.aldComputerService.ManageAldDataDialog;
import view.aldComputers.ManageAldComputersDialog;

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
        this.view.setManageDataMenuItemListener(this.setManageDataItemActionListener());
        this.view.setTableMenuItemListener(this.getTableMenuItemActionListener());
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

    private ActionListener getTableMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageAldComputersDialog macd = new ManageAldComputersDialog(view, true);
                ManageAldComputersController macc = new ManageAldComputersController(macd, model);
                macd.setVisible(true);
            }
        };
        return al;
    }
}
