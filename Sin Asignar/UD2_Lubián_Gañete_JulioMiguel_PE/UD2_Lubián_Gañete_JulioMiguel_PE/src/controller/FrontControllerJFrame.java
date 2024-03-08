/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.booking.BookingDialogController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Hotel;
import view.MainJFrame;
import view.booking.BookingDialog;

/**
 *
 * @author dides
 */
public class FrontControllerJFrame {

    private MainJFrame view;
    private Hotel model;

    public FrontControllerJFrame(MainJFrame view, Hotel model) {
        this.view = view;
        this.model = model;
        this.view.setQuitMenuItemListener(this.getQuitMenuItemActionListener());
        this.view.setShowBookingMenuItemListener(this.getShowBookingMenuItemActionListener());
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

    private ActionListener getShowBookingMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookingDialog bd = new BookingDialog(view, true);
                BookingDialogController bdc = new BookingDialogController(view,bd, model);
                bd.setVisible(true);
            }
        };
        return al;
    }
}
