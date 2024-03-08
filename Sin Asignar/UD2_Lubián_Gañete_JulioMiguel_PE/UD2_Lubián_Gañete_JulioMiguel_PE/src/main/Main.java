/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.FrontControllerJFrame;
import model.Hotel;
import view.MainJFrame;

/**
 *
 * @author dides
 */
public class Main {
    public static void main(String[] args) {
        MainJFrame mainview=new MainJFrame();
        Hotel ht=new Hotel();
        ht.populate();
        FrontControllerJFrame fc=new FrontControllerJFrame(mainview,ht);
        mainview.setVisible(true);
        
    }
}
