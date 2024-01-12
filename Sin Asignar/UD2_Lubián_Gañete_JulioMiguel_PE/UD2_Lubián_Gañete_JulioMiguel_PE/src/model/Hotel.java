/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashMap;

/**
 *
 * @author fermigo
 */
public class Hotel {

    public static String DEFAULTVALUE = "n/a";
    private String name;
    private HashMap<String, Booking> booking;

    public Hotel() {
        this.name = Hotel.DEFAULTVALUE;
        this.booking = new HashMap<>();
    }

    public Hotel(String name) {
        this.name = name;
        this.booking = new HashMap<>();
    }

    public HashMap<String, Booking> getBooking() {
        return booking;
    }

    public void setBooking(HashMap<String, Booking> booking) {
        this.booking = booking;
    }

    public void setBooking(Booking booking) {
        this.booking.put(booking.getHolder(), booking);
    }

    public Booking getBooking(String holder) {
        return this.booking.get(holder);
    }

    public void populate() {
        Booking bk1 = new Booking("Tom Hanks", Booking.RoomType.DOUBLE, Boolean.TRUE, Boolean.TRUE);
        Booking bk2 = new Booking("Samuel L. Jackson", Booking.RoomType.SINGLE, Boolean.TRUE, Boolean.FALSE);
        Booking bk3 = new Booking("Sandra Bullock", Booking.RoomType.SINGLE, Boolean.FALSE, Boolean.FALSE);
        Booking bk4 = new Booking("Anne Hathaway", Booking.RoomType.SINGLE, Boolean.FALSE, Boolean.FALSE);
        this.setBooking(bk1);
        this.setBooking(bk2);
        this.setBooking(bk3);
        this.setBooking(bk4);
    }

}
