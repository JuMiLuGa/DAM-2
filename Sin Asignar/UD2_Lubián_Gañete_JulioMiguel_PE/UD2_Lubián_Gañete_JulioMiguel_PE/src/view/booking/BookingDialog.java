/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.booking;

import java.awt.event.ActionListener;

/**
 *
 * @author fermigo
 */
public class BookingDialog extends javax.swing.JDialog {

    /**
     * Creates new form BookingDialog
     */
    public BookingDialog(java.awt.Frame parent, boolean modal) {
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

        bookingLabel = new javax.swing.JLabel();
        bookingHolderComboBox = new javax.swing.JComboBox<>();
        showBookingDetailsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bookingLabel.setText("Booking holder:");

        showBookingDetailsButton.setText("Show booking details...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookingLabel)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showBookingDetailsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookingHolderComboBox, 0, 258, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookingLabel)
                    .addComponent(bookingHolderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(showBookingDetailsButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setShowBookingDetailsButtonListener(ActionListener listener) {
        this.showBookingDetailsButton.addActionListener(listener);
    }

    public void setBookingHolderComboBoxListener(ActionListener listener) {
        this.bookingHolderComboBox.addActionListener(listener);
    }

    public void addBookingHolder(String bookingHolder) {
        this.bookingHolderComboBox.addItem(bookingHolder);
    }

    public String getBookingHolder() {
        return this.bookingHolderComboBox.getSelectedItem().toString();
    }

    public void setBookingHolderEnabled(boolean enabled) {
        bookingHolderComboBox.setEnabled(enabled);
    }

    public void setShowBookingDetailsEnabled(boolean enabled) {
        showBookingDetailsButton.setEnabled(enabled);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bookingHolderComboBox;
    private javax.swing.JLabel bookingLabel;
    private javax.swing.JButton showBookingDetailsButton;
    // End of variables declaration//GEN-END:variables
}
