package view;

import main.mainCalculatorMVC;

public class mainFrameView extends javax.swing.JFrame {

    public mainFrameView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainMenuBar = new javax.swing.JMenuBar();
        optionsMenu = new javax.swing.JMenu();
        calculatorMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        optionsMenu.setText("Options");

        calculatorMenuItem.setText("Calculator");
        calculatorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculatorMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(calculatorMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(exitMenuItem);

        mainMenuBar.add(optionsMenu);

        setJMenuBar(mainMenuBar);

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


    //Start code
    
    private void calculatorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatorMenuItemActionPerformed
        mainCalculatorMVC calculator = new mainCalculatorMVC();
        calculator.main(null);
    }//GEN-LAST:event_calculatorMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed
   
    //Finish code
     
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem calculatorMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenu optionsMenu;
    // End of variables declaration//GEN-END:variables
}
