/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.radioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.radioButton.RadioButtonDialog;

/**
 *
 * @author fermigo
 */
public class RadioButtonController {

    private final RadioButtonDialog view;

    public RadioButtonController(RadioButtonDialog view) {
        this.view = view;
        this.view.addGetOptionButtonActionListener(this.getGetOptionButtonActionListener());
    }

    private ActionListener getGetOptionButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = view.getSelectedOption();
                System.out.println("selected option: " + selectedOption);
            }
        };

        return al;

    }

}
