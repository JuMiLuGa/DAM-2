/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.tabbedPaneController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.tabbedPaneDialog.TabbedPane;

/**
 *
 * @author dides
 */
public class TabbedPaneController {

    private final TabbedPane view;

    public TabbedPaneController(TabbedPane view) {
        this.view = view;
        this.view.addIncreaseProgressbarButton(this.addProgressBarButtonActionListener());
        this.view.addGetSliderValueButton(this.addGetSliderValueButtonActionListener());
    }

    private ActionListener addProgressBarButtonActionListener() {
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

    private ActionListener addGetSliderValueButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(view, "Current value: " + view.getSliderValue());
            }
        };

        return al;

    }

}
