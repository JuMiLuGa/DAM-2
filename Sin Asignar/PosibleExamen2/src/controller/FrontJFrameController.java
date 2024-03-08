/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import view.MainJFrame;


/**
 *
 * @author fermigo
 */
public class FrontJFrameController {
    
    private MainJFrame view;
    
    public FrontJFrameController(MainJFrame view) {
        this.view = view;
        this.view.addPopupMenuItem(enableAlarm());
        this.view.addPopupMenuItem(disableAlarm());
        this.view.addQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.addPopupMenuMouseListener(this.getPopupMenuMouseListener());
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
    
    private JMenuItem enableAlarm() {
        JMenuItem mi = new JMenuItem();
        mi.setText("Activar Alarma");
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.enableAlarm();
                
                
                if(view.checkAlarm() == true){
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
                view.enableAlarm();
                
                if(view.checkAlarm() == true){
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
            System.out.println("pressed");
            checkPopup(me);
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            System.out.println("released");
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
