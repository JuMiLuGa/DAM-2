package controller.booking;

import controller.booking.info.BookingInfoController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.booking.BookingDataJDialog;
import view.booking.info.BookingInfoJDialog;

public class BookingDataController {

    private final BookingDataJDialog view;

    public BookingDataController(BookingDataJDialog view) {
        this.view = view;
        this.view.setShowDetailsButtonListener(setShowDetailsButtonActionListener());
    }

    private ActionListener setShowDetailsButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookingInfoJDialog bid = new BookingInfoJDialog(view, true);
                BookingInfoController bic = new BookingInfoController(bid);
                bid.setVisible(true);
            }
        };
        return al;
    }
}
