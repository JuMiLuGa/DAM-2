/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import controller.popupMenu.PopupMenuController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainJFrame;
import view.popupMenu.PopupMenu;


/**
 *
 * @author fermigo
 */
public class FrontJFrameController {
    
    private MainJFrame view;
    
    public FrontJFrameController(MainJFrame view) {
        this.view = view;
        this.view.addQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.addPopupMenuItemListener(this.getPopupMenuItemListener());
        this.view.enableAlarm();
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
    
    
    private ActionListener getPopupMenuItemListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PopupMenu pm = new PopupMenu(view, true);
                PopupMenuController pmc = new PopupMenuController(pm, view);
                pm.setVisible(true);
            }
        };
        return al;
    }
    
}
