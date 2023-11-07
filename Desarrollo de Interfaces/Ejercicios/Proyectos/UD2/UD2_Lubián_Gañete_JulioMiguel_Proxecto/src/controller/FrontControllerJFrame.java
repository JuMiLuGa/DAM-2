package controller;

import controller.manageData.ManageDataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainJFrame;
import view.manageData.ManageDataJDialog;

public class FrontControllerJFrame {

    private MainJFrame view;

    public FrontControllerJFrame(MainJFrame view) {
        this.view = view;
        this.view.setQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.setManageDataMenuItemListener(this.setManageDataMenuItemActionListener());
        
    }

    private ActionListener setQuitMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                System.exit(0);
            }
        };
        return al;
    }
    
    private ActionListener setManageDataMenuItemActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageDataJDialog mdd = new ManageDataJDialog(view, true);
                ManageDataController mddc = new ManageDataController(mdd);
                mdd.setVisible(true);
            }
        };
        return al;
    }

}
