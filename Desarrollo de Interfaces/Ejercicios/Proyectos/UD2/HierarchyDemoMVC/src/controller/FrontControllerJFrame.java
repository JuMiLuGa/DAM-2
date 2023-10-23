/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.pets.PetsController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.animal.Pets;
import view.MainJFrame;
import view.pets.PetsDialog;

/**
 *
 * @author dides
 */
public class FrontControllerJFrame {

    private MainJFrame view;

    public FrontControllerJFrame(MainJFrame view) {
        this.view = view;
        this.view.setQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.setPetsMenuItemListener(this.setPetsMenuItemActionListener());
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

    private ActionListener setPetsMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PetsDialog pd = new PetsDialog(view, true);
                Pets pets = Pets.getPets();
                PetsController pc = new PetsController(pd, pets);
                pd.setVisible(true);
            }
        };
        return al;
    }

}
