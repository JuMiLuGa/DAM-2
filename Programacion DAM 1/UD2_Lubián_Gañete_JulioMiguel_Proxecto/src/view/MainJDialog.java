package view;

import java.awt.event.ActionListener;

public class MainJDialog extends javax.swing.JDialog {

    /**
     * Creates new form MainJDialog
     */
    public MainJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainjMenuBar = new javax.swing.JMenuBar();
        mainjMenu = new javax.swing.JMenu();
        manageDatajMenuItem = new javax.swing.JMenuItem();
        quitjMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainjMenu.setText("File");

        manageDatajMenuItem.setText("Manage Data");
        mainjMenu.add(manageDatajMenuItem);

        quitjMenuItem.setText("Quit");
        mainjMenu.add(quitjMenuItem);

        mainjMenuBar.add(mainjMenu);

        setJMenuBar(mainjMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setQuitMenuItemListener(ActionListener listener) {
        this.quitjMenuItem.addActionListener(listener);
    }
    
    public void setManageDataItemListener(ActionListener listener) {
        this.manageDatajMenuItem.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu mainjMenu;
    private javax.swing.JMenuBar mainjMenuBar;
    private javax.swing.JMenuItem manageDatajMenuItem;
    private javax.swing.JMenuItem quitjMenuItem;
    // End of variables declaration//GEN-END:variables
}
