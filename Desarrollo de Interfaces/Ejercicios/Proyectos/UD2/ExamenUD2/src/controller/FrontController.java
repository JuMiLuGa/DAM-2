package controller;

import controller.booking.BookingDataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FrontViewJFrame;
import view.booking.BookingDataJDialog;

public class FrontController {
    
    private FrontViewJFrame view;
    
     public FrontController(FrontViewJFrame view) {
        this.view = view;
        this.view.setQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.setBookingMenuItemListener(this.setBookingMenuItemActionListener());
        
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
    
    private ActionListener setBookingMenuItemActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookingDataJDialog mdd = new BookingDataJDialog(view, true);
                BookingDataController mdc = new BookingDataController(mdd);
                mdd.setVisible(true);
            }
        };
        return al;
    }
}
