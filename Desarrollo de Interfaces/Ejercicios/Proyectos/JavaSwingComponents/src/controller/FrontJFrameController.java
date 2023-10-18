/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.checkBox.CheckBoxController;
import controller.comboBox.ComboBoxController;
import controller.messageDialog.MessageDialogController;
import controller.radioButton.RadioButtonController;
import controller.tabbedPaneController.TabbedPaneController;
import controller.textEditor.TextEditorController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainJFrame;
import view.checkBox.CheckBoxDialog;
import view.comboBox.ComboBoxDialog;
import view.messageDialog.MessageDialogDialog;
import view.radioButton.RadioButtonDialog;
import view.tabbedPaneDialog.TabbedPane;
import view.textEditor.TextEditorDialog;

/**
 *
 * @author dides
 */
public class FrontJFrameController {

    private MainJFrame view;

    public FrontJFrameController(MainJFrame view) {
        this.view = view;
        this.view.setQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.setMessageDialogMenuItemListener(this.setMessageDialogMenuItemActionListener());
        this.view.setRadioButtonDialogMenuItemListener(this.setRadioButtonDialogMenuItemActionListener());
        this.view.setCheckBoxButtonDialogMenuItemListener(this.setCheckBoxDialogMenuItemActionListener());
        this.view.setComboBoxButtonDialogMenuItemListener(this.setComboBoxDialogMenuItemActionListener());
        this.view.setTextEditorMenuItemListener(this.setTextEditorMenuItemActionListener());
        this.view.setTabbedPaneMenuItemListener(this.setTabbedPaneMenuItemActionListener());
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

    private ActionListener setMessageDialogMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MessageDialogDialog md = new MessageDialogDialog(view, true);
                MessageDialogController mdc = new MessageDialogController(md);
                md.setVisible(true);
            }
        };
        return al;
    }

    private ActionListener setRadioButtonDialogMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RadioButtonDialog md = new RadioButtonDialog(view, true);
                RadioButtonController mdc = new RadioButtonController(md);
                md.setVisible(true);
            }
        };
        return al;
    }

    private ActionListener setCheckBoxDialogMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckBoxDialog cb = new CheckBoxDialog(view, true);
                CheckBoxController cbc = new CheckBoxController(cb);
                cb.setVisible(true);
            }
        };
        return al;
    }

    private ActionListener setComboBoxDialogMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComboBoxDialog cb = new ComboBoxDialog(view, true);
                ComboBoxController cbc = new ComboBoxController(cb);
                cb.setVisible(true);
            }
        };
        return al;
    }

    private ActionListener setTextEditorMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextEditorDialog ted = new TextEditorDialog(view, true);
                TextEditorController tec = new TextEditorController(ted);
                ted.setVisible(true);
            }
        };
        return al;
    }
    
    
        private ActionListener setTabbedPaneMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TabbedPane tp = new TabbedPane(view, true);
                TabbedPaneController tpc = new TabbedPaneController(tp);
                tp.setVisible(true);
            }
        };
        return al;
    }

}
