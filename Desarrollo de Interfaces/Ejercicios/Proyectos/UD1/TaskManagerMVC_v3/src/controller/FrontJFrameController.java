package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.Main;


public class FrontJFrameController {
    
    private main.Main view;

    public FrontJFrameController(Main view) {
        this.view = view;
        this.view.setQuitMenuItemActionListener(this.setQuitMenuItemActionListener());
    }
    
    private ActionListener setQuitMenuItemActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   view.dispose();
            }
        };
        return al;
    }
}
