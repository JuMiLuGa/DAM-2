package controller.booking.details;

import model.Booking;
import model.Booking.RoomType;
import model.Hotel;
import view.booking.details.ReserveDetailsJDialog;

public class ReserveDetailsController {

    private ReserveDetailsJDialog view;
    private Booking model;
    
    
    public ReserveDetailsController(ReserveDetailsJDialog rdd, Booking model) {
        this.view = rdd;
        this.model = model;
        this.view.setBookingHolderTextFieldText(this.getBookingHolder());
        this.view.setSmokerCheckboxSelected(this.getSmoker());
        this.view.setWifiCheckboxSelected(this.getWifi());
        this.getRoomType();
        disableAll();
            }

    

    private void disableAll(){
        this.view.setAllDisabled(false);
    }
    
    private boolean getSmoker(){
        return this.model.isSmoker();
    }
    
    private boolean getWifi() {
        return this.model.isWifi();
    }
    
    private String getBookingHolder() {
        return this.model.getHolder();
    }

    private void getRoomType(){
        this.view.setRoomTypeComboBox(this.model.getRoomType().toString());
    }
    
}
