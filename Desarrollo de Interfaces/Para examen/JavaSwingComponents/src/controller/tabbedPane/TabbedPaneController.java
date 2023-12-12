/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.tabbedPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.tabbedPane.TabbedPane;

/**
 *
 * @author fermigo
 */
public class TabbedPaneController {

    private final TabbedPane view;

    public TabbedPaneController(TabbedPane view) {
        this.view = view;
        this.view.addIncreaseProgressbarButton(this.getProgressBarButtonActionListener());
        this.view.addGetSliderValueButton(this.getGetSliderValueButtonActionListener());
        this.view.addGetSpinnerValueButtonButton(this.getGetSpinnerValueButtonActionListener());
    }

    private ActionListener getProgressBarButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int max = view.getProgressBarMaxValue();
                int current = view.getProgressBarValue();
                int increase = 10;
                int next = current + increase;
                if (next <= max) {
                    view.setProgressBarValue(next);
                } else {
                    view.setProgressBarValue(0);
                }
            }
        };
        return al;

    }

    private ActionListener getGetSliderValueButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(view, "Current value: " + view.getSliderValue());
            }
        };
        return al;
    }

    private ActionListener getGetSpinnerValueButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(view, "Current value: " + view.getSpinnerValue());
            }
        };
        return al;
    }

}
