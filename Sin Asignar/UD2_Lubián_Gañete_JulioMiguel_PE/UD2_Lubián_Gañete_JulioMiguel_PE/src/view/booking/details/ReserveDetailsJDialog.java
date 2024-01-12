package view.booking.details;

import model.Booking;
import view.booking.BookingDialog;

public class ReserveDetailsJDialog extends javax.swing.JDialog {


    public ReserveDetailsJDialog(BookingDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookingHolderLabel = new javax.swing.JLabel();
        bookingHolderTextField = new javax.swing.JTextField();
        roomTypeLabel = new javax.swing.JLabel();
        roomTypeComboBox = new javax.swing.JComboBox<>();
        smokerCheckBox = new javax.swing.JCheckBox();
        wifiCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bookingHolderLabel.setText("Booking Holder:");

        roomTypeLabel.setText("Room Type:");

        smokerCheckBox.setText("Smoker");

        wifiCheckBox.setText("Wifi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookingHolderLabel)
                            .addComponent(roomTypeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bookingHolderTextField)
                            .addComponent(roomTypeComboBox, 0, 258, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wifiCheckBox)
                            .addComponent(smokerCheckBox))))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookingHolderLabel)
                    .addComponent(bookingHolderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomTypeLabel)
                    .addComponent(roomTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(smokerCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wifiCheckBox)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setAllDisabled(boolean bool) {
        this.bookingHolderTextField.setEnabled(bool);
        this.roomTypeComboBox.setEnabled(bool);
        this.smokerCheckBox.setEnabled(bool);
        this.wifiCheckBox.setEnabled(bool);
    }
    
    public void setBookingHolderTextFieldText(String holder) {
        this.bookingHolderTextField.setText(holder);
    }
    
   public void setSmokerCheckboxSelected(boolean smoker) {
        this.smokerCheckBox.setSelected(smoker);
    }
   
   public void setWifiCheckboxSelected(boolean wifi) {
        this.wifiCheckBox.setSelected(wifi);
    }
   
   public void setRoomTypeComboBox(String roomType) {
        this.roomTypeComboBox.addItem(roomType);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bookingHolderLabel;
    private javax.swing.JTextField bookingHolderTextField;
    private javax.swing.JComboBox<String> roomTypeComboBox;
    private javax.swing.JLabel roomTypeLabel;
    private javax.swing.JCheckBox smokerCheckBox;
    private javax.swing.JCheckBox wifiCheckBox;
    // End of variables declaration//GEN-END:variables

    

    
}
