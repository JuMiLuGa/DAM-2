/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import view.MainJFrame;

/**
 *
 * @author dides
 */
public class FrontControllerJFrame {

    private MainJFrame view;

    public FrontControllerJFrame(MainJFrame view) {
        this.view = view;
        this.view.setQuitMenuItemListener(this.setQuitMenuItemActionListener());
        this.view.addPopupMenuItem(this.enableAlarm());
        this.view.addPopupMenuItem(this.disableAlarm());
        this.view.addMouseListener(this.getPopupMouseListener());
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
                view.disableAlarm();
                
                if(view.checkAlarm() == true){
                    JOptionPane.showMessageDialog(view, "Alarma Desactivada");
                } else{
                    JOptionPane.showMessageDialog(view, "Error al desactivar alarma");
                }
            }
        });
        return mi;
    }

    private MouseListener getPopupMouseListener() {
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked");
                }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    System.out.println("Mouse pressed");
                    view.showPopupMenu(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse entered region");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse exited");
            }
        };
        return ml;
    }
    
    
}
