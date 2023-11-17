package model.aldComputerService;

import view.manageData.ManageDataJDialog;

public class aldComputerServiceModel {
   
    private ManageDataJDialog view;
    
    private String name;
    private String address;
    private String phone;
    private String employees;

    public aldComputerServiceModel(String name, String address, String phone, String employees) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.employees = employees;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }
    
    
}
