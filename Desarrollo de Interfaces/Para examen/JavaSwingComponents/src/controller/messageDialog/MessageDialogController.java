/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.messageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.messageDialog.MessageDialogDialog;

/**
 *
 * @author fermigo
 */
public class MessageDialogController {

    private final MessageDialogDialog view;

    public MessageDialogController(MessageDialogDialog view) {
        this.view = view;
        this.view.addMessageDialogActionListener(this.getMessageDialogActionListener());
        this.view.addConfirmDialogActionListener(this.getConfirmDialogActionListener());
    }

    private ActionListener getMessageDialogActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(view, "Demo message");
            }
        };
        return al;
    }

    private ActionListener getConfirmDialogActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(view, "Accept or Cancel?");
                System.out.println("Confirm Dialog return value: " + result);
            }
        };
        return al;
    }

}
