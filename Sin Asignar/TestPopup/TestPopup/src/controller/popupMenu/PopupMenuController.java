/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.popupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import view.MainJFrame;
import view.popupMenu.PopupMenu;

/**
 *
 * @author maceira_barca_xian
 */
 
public class PopupMenuController {
    
    private final PopupMenu view;
    private final MainJFrame mainview;
    private boolean alarm;
    
    /*public PopupMenuController(PopupMenu view) {
        this.view = view;
        this.view.addPopupMenuItem(this.Option1());
        this.view.addPopupMenuItem(this.Option2());
        this.view.addPopupMenuMouseListener(this.getPopupMenuMouseListener());
    }*/

    public PopupMenuController(PopupMenu view, MainJFrame mainview) {
        this.view = view;
        this.mainview = mainview;
        this.view.addPopupMenuItem(this.Option1());
        this.view.addPopupMenuItem(this.Option2());
        this.view.addPopupMenuMouseListener(this.getPopupMenuMouseListener());
    }

    private JMenuItem Option1() {
        JMenuItem mi = new JMenuItem();
        mi.setText("Enable Alarm");
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainview.enableAlarm();
                System.out.println(mainview.getAlarmState());
            }
        });
        return mi;
    }

    private JMenuItem Option2() {
        JMenuItem mi = new JMenuItem();
        mi.setText("Disable alarm");
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainview.disableAlarm();
                System.out.println(mainview.getAlarmState());
            }
        });
        return mi;
    }
    
    private MouseListener getPopupMenuMouseListener() {
        MouseListener ml=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                if(me.isPopupTrigger()) {
                    view.showPopupMenu(me);
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        };
        return ml;
    }

}
