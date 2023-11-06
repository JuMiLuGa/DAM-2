/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.donations.donationsController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainJFrame;
import view.donations.donationsJDialog;

/**
 *
 * @author dides
 */
public class FrontControllerJFrame {

    private MainJFrame view;

    public FrontControllerJFrame(MainJFrame view) {
        this.view = view;
        this.view.setQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.setDonationsItemListener(this.setDonationsMenuItemActionListener());
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

    private ActionListener setDonationsMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donationsJDialog dns = new donationsJDialog(view, true);
                donationsController dnsc = new donationsController(dns);
                dns.setVisible(true);
            }
        };
        return al;
    }
}
