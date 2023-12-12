/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.popupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import view.MainJFrame;
import view.popupMenu.PopupMenu;

/**
 *
 * @author fermigo
 */
public class PopupMenuController {

    private final PopupMenu view;
    private final MainJFrame mainView;
    
    public PopupMenuController(PopupMenu view, MainJFrame mainView) {
    this.view = view;
    this.mainView = mainView;
    this.view.addPopupMenuItem(this.enableAlarm());
    this.view.addPopupMenuItem(this.disableAlarm());
    this.view.addPopupMenuMouseListener(this.getPopupMenuMouseListener());
}


    private JMenuItem enableAlarm() {
        JMenuItem mi = new JMenuItem();
        mi.setText("Activar Alarma");
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainView.enableAlarm();
                
                
                if(mainView.checkAlarm() == true){
                    JOptionPane.showMessageDialog(view, "Alarma Activada");
                } else{
                    JOptionPane.showMessageDialog(view, "Error al activar alarma");
                }
                              
            }
        });
        return mi;
    }

    private JMenuItem disableAlarm() {
        JMenuItem mi = new JMenuItem();
        mi.setText("Desactivar Alarma");
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainView.enableAlarm();
                
                if(mainView.checkAlarm() == true){
                    JOptionPane.showMessageDialog(view, "Alarma Desactivada");
                } else{
                    JOptionPane.showMessageDialog(view, "Error al desactivar alarma");
                }
            }
        });
        return mi;
    }
    
    private MouseListener getPopupMenuMouseListener() {
    MouseListener ml = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent me) {
            checkPopup(me);
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            checkPopup(me);
        }

        private void checkPopup(MouseEvent me) {
            if (me.isPopupTrigger()) {
                view.showPopupMenu(me);
            }
        }
    };
    return ml;
}



}
