/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fermigo
 */
public class Booking {

    public static String DEFAULTVALUE = "n/a";

    public static enum RoomType {
        SINGLE,
        DOUBLE
    }

    private String holder;
    private RoomType roomType;
    private Boolean wifi;
    private Boolean smoker;

    public Booking() {
        this.holder = Booking.DEFAULTVALUE;
        this.roomType = Booking.RoomType.SINGLE;
        this.wifi = false;
        this.smoker = false;
    }

    public Booking(String holder, RoomType roomType, Boolean wifi, Boolean smoking) {
        this.holder = holder;
        this.roomType = roomType;
        this.wifi = wifi;
        this.smoker = smoking;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Boolean isWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(Boolean smoker) {
        this.smoker = smoker;
    }

}
