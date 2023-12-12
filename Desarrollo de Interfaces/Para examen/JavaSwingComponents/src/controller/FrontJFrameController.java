/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.checkBox.CheckBoxController;
import controller.comboBox.ComboBoxController;
import controller.messageDialog.MessageDialogController;
import controller.popupMenu.PopupMenuController;
import controller.radioButton.RadioButtonController;
import controller.tabbedPane.TabbedPaneController;
import controller.table.TableController;
import controller.textEditor.TextEditorController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainJFrame;
import view.checkBox.CheckBoxDialog;
import view.comboBox.ComboBoxDialog;
import view.messageDialog.MessageDialogDialog;
import view.popupMenu.PopupMenu;
import view.radioButton.RadioButtonDialog;
import view.tabbedPane.TabbedPane;
import view.table.TableDialog;
import view.textEditor.TextEditorDialog;

/**
 *
 * @author fermigo
 */
public class FrontJFrameController {
    
    private MainJFrame view;
    
    public FrontJFrameController(MainJFrame view) {
        this.view = view;
        this.view.addQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.addMessageDialogMenuItemListener(this.getMessageDialogMenuItemActionListener());
        this.view.addRadioButtonDialogMenuItemListener(this.getRadioButtonDialogMenuItemActionListener());
        this.view.addCheckBoxButtonDialogMenuItemListener(this.getCheckBoxDialogMenuItemActionListener());
        this.view.addComboBoxButtonDialogMenuItemListener(this.getComboBoxDialogMenuItemActionListener());
        this.view.addTextEditorMenuItemListener(this.getTextEditorMenuItemActionListener());
        this.view.addTabbedPaneMenuItemListener(this.getTabbedPaneMenuItemActionListener());
        this.view.addTableMenuItemItemListener(this.getTableMenuItemItemListener());
        this.view.addPopupMenuItemListener(this.getPopupMenuItemListener());
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
    
    private ActionListener getMessageDialogMenuItemActionListener() {
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
    
    private ActionListener getRadioButtonDialogMenuItemActionListener() {
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
    
    private ActionListener getCheckBoxDialogMenuItemActionListener() {
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
    
    private ActionListener getComboBoxDialogMenuItemActionListener() {
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
    
    private ActionListener getTextEditorMenuItemActionListener() {
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
    
    private ActionListener getTabbedPaneMenuItemActionListener() {
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
    
    private ActionListener getTableMenuItemItemListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableDialog td = new TableDialog(view, true);
                TableController tc = new TableController(td);
                td.setVisible(true);
            }
        };
        return al;
    }
    
    private ActionListener getPopupMenuItemListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PopupMenu pm = new PopupMenu(view, true);
                PopupMenuController pmc = new PopupMenuController(pm);
                pm.setVisible(true);
            }
        };
        return al;
    }
    
}
