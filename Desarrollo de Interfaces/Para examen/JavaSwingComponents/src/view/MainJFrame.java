/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;

/**
 *
 * @author fermigo
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
        MessageDialogMenuItem = new javax.swing.JMenuItem();
        radioButtonMenuItem = new javax.swing.JMenuItem();
        checkBoxMenuItem = new javax.swing.JMenuItem();
        comboBoxMenuItem = new javax.swing.JMenuItem();
        textEditMenuItem = new javax.swing.JMenuItem();
        tabbedPaneMenuItem = new javax.swing.JMenuItem();
        tableMenuItem = new javax.swing.JMenuItem();
        popupMenuItem = new javax.swing.JMenuItem();
        quitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setText("File");

        MessageDialogMenuItem.setText("Message Dialog...");
        fileMenu.add(MessageDialogMenuItem);

        radioButtonMenuItem.setText("Radio Button...");
        fileMenu.add(radioButtonMenuItem);

        checkBoxMenuItem.setText("Check Box...");
        checkBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(checkBoxMenuItem);

        comboBoxMenuItem.setText("Combo Box + Color...");
        fileMenu.add(comboBoxMenuItem);

        textEditMenuItem.setText("Text Editor...");
        textEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEditMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(textEditMenuItem);

        tabbedPaneMenuItem.setText("Tabbed Pane...");
        fileMenu.add(tabbedPaneMenuItem);

        tableMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        tableMenuItem.setText("Table...");
        tableMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(tableMenuItem);

        popupMenuItem.setText("Popup Menu...");
        fileMenu.add(popupMenuItem);

        quitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
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

    private void checkBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxMenuItemActionPerformed

    private void textEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEditMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEditMenuItemActionPerformed

    private void tableMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMenuItemActionPerformed

    public void addQuitMenuItemListener(ActionListener listener) {
        this.quitMenuItem.addActionListener(listener);
    }

    public void addMessageDialogMenuItemListener(ActionListener listener) {
        this.MessageDialogMenuItem.addActionListener(listener);
    }

    public void addRadioButtonDialogMenuItemListener(ActionListener listener) {
        this.radioButtonMenuItem.addActionListener(listener);
    }

    public void addCheckBoxButtonDialogMenuItemListener(ActionListener listener) {
        this.checkBoxMenuItem.addActionListener(listener);
    }

    public void addComboBoxButtonDialogMenuItemListener(ActionListener listener) {
        this.comboBoxMenuItem.addActionListener(listener);
    }

    public void addTextEditorMenuItemListener(ActionListener listener) {
        this.textEditMenuItem.addActionListener(listener);
    }

    public void addTabbedPaneMenuItemListener(ActionListener listener) {
        this.tabbedPaneMenuItem.addActionListener(listener);
    }

    public void addTableMenuItemItemListener(ActionListener listener) {
        this.tableMenuItem.addActionListener(listener);
    }

    public void addPopupMenuItemListener(ActionListener listener) {
        this.popupMenuItem.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MessageDialogMenuItem;
    private javax.swing.JMenuItem checkBoxMenuItem;
    private javax.swing.JMenuItem comboBoxMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem popupMenuItem;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JMenuItem radioButtonMenuItem;
    private javax.swing.JMenuItem tabbedPaneMenuItem;
    private javax.swing.JMenuItem tableMenuItem;
    private javax.swing.JMenuItem textEditMenuItem;
    // End of variables declaration//GEN-END:variables
}
