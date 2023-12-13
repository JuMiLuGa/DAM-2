/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.aldComputerService;

/**
 *
 * @author DAM2_Alu10
 */
public class Laptop extends Computer{
    private int batteryMAh;
    private boolean thunderbolt;

    public Laptop(String Serial, String Brand, String Model) {
        super(Serial, Brand, Model);
        this.batteryMAh = 0;
        this.thunderbolt = false;
    }
    
    public Laptop(int batteryMAh, boolean thunderbolt, String Serial, String Brand, String Model) {
        super(Serial, Brand, Model);
        this.batteryMAh = batteryMAh;
        this.thunderbolt = thunderbolt;
    }

    public int getBatteryMAh() {
        return batteryMAh;
    }

    public void setBatteryMAh(int batteryMAh) {
        this.batteryMAh = batteryMAh;
    }

    public boolean isThunderbolt() {
        return thunderbolt;
    }

    public void setThunderbolt(boolean thunderbolt) {
        this.thunderbolt = thunderbolt;
    }
    
    
          
}
