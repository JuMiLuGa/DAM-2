/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.popupMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;

/**
 *
 * @author fermigo
 */
public class PopupMenu extends javax.swing.JDialog {

    /**
     * Creates new form PopupMenu
     */
    public PopupMenu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        samplePopupMenu = new javax.swing.JPopupMenu();
        popupMenuLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        popupMenuLabel.setText("Popup Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(popupMenuLabel)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(popupMenuLabel)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addPopupMenuItem(JMenuItem item) {
        this.samplePopupMenu.add(item);
    }

    public void addPopupMenuMouseListener(MouseListener listener) {
        this.addMouseListener(listener);
    }
    
    public void showPopupMenu(MouseEvent me) {
        this.samplePopupMenu.show(me.getComponent(), me.getX(), me.getY());
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel popupMenuLabel;
    private javax.swing.JPopupMenu samplePopupMenu;
    // End of variables declaration//GEN-END:variables
}