package main;

import controller.FrontControllerJFrame;
import model.aldComputerService.aldComputerServiceModel;
import view.MainJFrame;

public class Main {
    public static void main(String[] args) {
        MainJFrame mainview=new MainJFrame();
        FrontControllerJFrame fc = new FrontControllerJFrame(mainview);
        mainview.setVisible(true);
        
    }
}
