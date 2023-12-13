/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.aldComputerService;

import java.util.HashMap;

/**
 *
 * @author DAM2_Alu10
 */
public abstract class Computer {
    
    private String Serial;
    private String Brand;
    private String Model;

    public Computer(String Serial, String Brand, String Model) {
        this.Serial = Serial;
        this.Brand = Brand;
        this.Model = Model;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String Serial) {
        this.Serial = Serial;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }
    
    
}
