package main;

import controller.FrontController;
import view.FrontViewJFrame;

public class Main {
    
    public static void main(String[] args) {
        FrontViewJFrame fvf = new FrontViewJFrame();
        FrontController fc = new FrontController(fvf);
        fvf.setVisible(true);
    }
}