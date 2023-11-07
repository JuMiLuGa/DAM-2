package main;

import controller.FrontControllerJFrame;
import view.MainJFrame;

public class Main {
    public static void main(String[] args) {
        MainJFrame mainview=new MainJFrame();
        FrontControllerJFrame fc = new FrontControllerJFrame(mainview);
        mainview.setVisible(true);
        
    }
}
