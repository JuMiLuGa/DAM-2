package view;

import java.awt.event.ActionListener;
import javax.swing.event.AncestorListener;
import main.CalculatorMVC;


public class MainView extends javax.swing.JFrame {

  
    public MainView() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        calculatorjMenuItem = new javax.swing.JMenuItem();
        quitjMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        calculatorjMenuItem.setText("Calculator");
        calculatorjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculatorjMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(calculatorjMenuItem);

        quitjMenuItem.setText("Quit");
        jMenu1.add(quitjMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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

    private void calculatorjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatorjMenuItemActionPerformed
        
        CalculatorMVC calculator = new CalculatorMVC();
        calculator.main(null);
        
    }//GEN-LAST:event_calculatorjMenuItemActionPerformed
                                               

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.exit(0);
    }               
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem calculatorjMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem quitjMenuItem;
    // End of variables declaration//GEN-END:variables

 
}
