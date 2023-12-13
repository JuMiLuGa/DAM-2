/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model.aldComputerService;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Lubián_Gañete_Julio_Miguel
 */

public class AldComputerService {

    private String name;
    private String address;
    private String telephoneNumber;
    private int numberOfEmployees;
    private HashMap<String, Computer> computers = new HashMap<>();

    public AldComputerService() {
        this.name = "";
        this.address = "";
        this.telephoneNumber = "";
        this.numberOfEmployees = 0;
        addDefautComputers();
    }

    public void addDefautComputers(){
        Laptop laptop = new Laptop(12500, true, "Laptop-0", "Acer", "Nitro 5");
        CryptoRig cryptoRig = new CryptoRig(4, 48, "CryptoRig-0", "Nvidia", "Rig500");
        PersonalComputer personalComputer = new PersonalComputer("AMD Ryzen 7800x3D", "Nvidia RTX-4080Ti", 600, "PersonalComputer-0", "HP", "ENVY");
        
        computers.put(laptop.getSerial(), laptop);
        computers.put(personalComputer.getSerial(), personalComputer);
        computers.put(cryptoRig.getSerial(), cryptoRig);
    }
    
    public Collection<Computer> getComputers(){
        return computers.values();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "Telephone Number: " + telephoneNumber + "\n"
                + "Number of Employees: " + numberOfEmployees;
    }

}
