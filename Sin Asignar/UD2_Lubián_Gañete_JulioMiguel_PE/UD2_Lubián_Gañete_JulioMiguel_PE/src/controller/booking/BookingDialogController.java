/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.booking;

import controller.booking.details.ReserveDetailsController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Booking;
import model.Hotel;
import view.MainJFrame;
import view.booking.BookingDialog;
import view.booking.details.ReserveDetailsJDialog;

/**
 *
 * @author fermigo
 */
public class BookingDialogController {

    public static String DEFAULTSTR = "Select...";
    private BookingDialog view;
    private Hotel model;
    private MainJFrame parentFrame;

    public BookingDialogController(MainJFrame parentFrame, BookingDialog view, Hotel model) {
        this.parentFrame = parentFrame;
        this.view = view;
        this.model = model;
        this.view.setBookingHolderComboBoxListener(this.getBookingHolderComboBoxListener());
        this.view.setShowBookingDetailsButtonListener(setShowBookingDetailsButtonListener());
        this.initDialog();
    }

    private void initDialog() {
        this.view.addBookingHolder(DEFAULTSTR);
        for (String holder : model.getBooking().keySet()) {
            this.view.addBookingHolder(holder);
        }
        this.view.setBookingHolderEnabled(true);
        this.view.setShowBookingDetailsEnabled(false);
    }

    private ActionListener getBookingHolderComboBoxListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getBookingHolder().equals(DEFAULTSTR)) {
                    view.setShowBookingDetailsEnabled(false);
                } else {
                    view.setShowBookingDetailsEnabled(true);
                }
            }
        };
        return al;
    }

    private ActionListener setShowBookingDetailsButtonListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReserveDetailsJDialog rdd = new ReserveDetailsJDialog(view, true);
                Booking booking = model.getBooking(view.getBookingHolder());
                ReserveDetailsController rdc = new ReserveDetailsController(rdd, booking);
                rdd.setVisible(true);
            }
        };
        return al;
    }
    
    

}
