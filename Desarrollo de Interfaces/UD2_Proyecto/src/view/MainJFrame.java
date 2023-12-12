/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;

/**
 *
 * @author dides
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
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

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        manageDataMenuItem = new javax.swing.JMenuItem();
        quitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setText("File");

        manageDataMenuItem.setText("Manage data...");
        fileMenu.add(manageDataMenuItem);

        quitMenuItem.setText("Quit");
        fileMenu.add(quitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setQuitMenuItemListener(ActionListener listener) {
        this.quitMenuItem.addActionListener(listener);
    }

    public void setManageDataMenuItemListener(ActionListener listener) {
        this.manageDataMenuItem.addActionListener(listener);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem manageDataMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem quitMenuItem;
    // End of variables declaration//GEN-END:variables
}
