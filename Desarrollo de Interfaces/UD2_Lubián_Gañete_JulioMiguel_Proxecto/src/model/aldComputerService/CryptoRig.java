/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.aldComputerService;

/**
 *
 * @author DAM2_Alu10
 */
public class CryptoRig extends Computer{
    private int numberOfGraphicCards;
    private int vRAMTotal;
    
    public CryptoRig(String Serial, String Brand, String Model) {
        super(Serial, Brand, Model);
        this.numberOfGraphicCards = 0;
        this.vRAMTotal = 0;
    }
    
    public CryptoRig(int numberOfGraphicCards, int vRAMTotal, String Serial, String Brand, String Model) {
        super(Serial, Brand, Model);
        this.numberOfGraphicCards = numberOfGraphicCards;
        this.vRAMTotal = vRAMTotal;
    }

    public int getNumberOfGraphicCards() {
        return numberOfGraphicCards;
    }

    public void setNumberOfGraphicCards(int numberOfGraphicCards) {
        this.numberOfGraphicCards = numberOfGraphicCards;
    }

    public int getvRAMTotal() {
        return vRAMTotal;
    }

    public void setvRAMTotal(int vRAMTotal) {
        this.vRAMTotal = vRAMTotal;
    }
    
    
}
