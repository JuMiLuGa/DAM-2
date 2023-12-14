/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.aldComputerService;

/**
 *
 * @author DAM2_Alu10
 */
public class PersonalComputer extends Computer{
    
    private String cpu;
    private String gpu;
    private int networkCardSpeed;

    public PersonalComputer(ComputerType computerType, String cpu, String gpu, int networkCardSpeed, String Serial, String Brand, String Model) {
        super(computerType,Serial, Brand, Model);
        this.cpu = cpu;
        this.gpu = gpu;
        this.networkCardSpeed = networkCardSpeed;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getNetworkCardSpeed() {
        return networkCardSpeed;
    }

    public void setNetworkCardSpeed(int networkCardSpeed) {
        this.networkCardSpeed = networkCardSpeed;
    }
    
    
    
    
}
