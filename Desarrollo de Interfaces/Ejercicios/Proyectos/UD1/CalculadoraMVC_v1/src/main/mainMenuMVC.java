package main;

import view.mainFrameView;
import javax.swing.JFrame;

public class mainMenuMVC {
    
    public static void main(String[] args){
        
        mainFrameView mfv = new mainFrameView();
        mfv.setTitle("Menu Options");
        mfv.setVisible(true);
    }
}
