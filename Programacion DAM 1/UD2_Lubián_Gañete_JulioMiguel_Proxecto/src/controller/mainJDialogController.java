/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import controller.manageDataController.manageDataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainJDialog;
import view.manageData.ManageDataJDialog;



public class mainJDialogController {

    private MainJDialog view;

    public mainJDialogController(MainJDialog view) {
        this.view = view;
        this.view.setQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.setManageDataItemListener(this.setManageDataMenuItemActionListener());
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

    private ActionListener setManageDataMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageDataJDialog mdd = new ManageDataJDialog(view, true);
                manageDataController mddc = new manageDataController(mdd);
                mdd.setVisible(true);
            }
        };
        return al;
    }
}
