/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view.aldComputerService;

import java.awt.event.ActionListener;

/**
 *
 * @author Lubián_Gañete_Julio_Miguel
 */

public class ManageAldDataDialog extends javax.swing.JDialog {

    /**
     * Creates new form ManageAldDataDialog
     */
    public ManageAldDataDialog(java.awt.Frame parent, boolean modal) {
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

        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        numberOfEmployeesLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        phoneNumberTextField = new javax.swing.JTextField();
        numberOfEmployeesSpinner = new javax.swing.JSpinner();
        saveButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nameLabel.setText("Name:");

        addressLabel.setText("Address:");

        phoneNumberLabel.setText("Phone number:");

        numberOfEmployeesLabel.setText("Number of employees:");

        nameTextField.setToolTipText("Escriba aqui el nombre de la empresa");

        addressTextField.setToolTipText("Escriba aqui la direccion de la empresa");

        phoneNumberTextField.setToolTipText("Escriba aqui su numero de telefono");

        numberOfEmployeesSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        numberOfEmployeesSpinner.setToolTipText("Seleccionar numero de empleados de la empresa");

        saveButton.setText("Save");

        editButton.setText("Edit");

        cancelButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numberOfEmployeesLabel)
                    .addComponent(nameLabel)
                    .addComponent(addressLabel)
                    .addComponent(phoneNumberLabel)
                    .addComponent(saveButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phoneNumberTextField)
                            .addComponent(addressTextField)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(75, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numberOfEmployeesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfEmployeesLabel)
                    .addComponent(numberOfEmployeesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(editButton)
                    .addComponent(cancelButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setCancelButtonActionListener(ActionListener listener) {
        this.cancelButton.addActionListener(listener);
    }

    public void setEditButtonActionListener(ActionListener listener) {
        this.editButton.addActionListener(listener);
    }

    public void setSaveButtonActionListener(ActionListener listener) {
        this.saveButton.addActionListener(listener);
    }

    public String getNameText() {
        return nameTextField.getText();
    }

    public String getAddressText() {
        return addressTextField.getText();
    }

    public String getTelephoneNumberText() {
        return phoneNumberTextField.getText();
    }

    public int getNumberOfEmployeesValue() {
        return (int) numberOfEmployeesSpinner.getValue();
    }

    public void setNameText(String text) {
        nameTextField.setText(text);
    }

    public void setAddressText(String text) {
        addressTextField.setText(text);
    }

    public void setTelephoneNumberText(String text) {
        phoneNumberTextField.setText(text);
    }

    public void setNumberOfEmployeesValue(int value) {
        numberOfEmployeesSpinner.setValue(value);
    }

    public void setEnabledSaveButton(boolean b) {
        this.saveButton.setEnabled(b);
    }

    public void setEnabledEditButton(boolean b) {
        this.editButton.setEnabled(b);
    }

    public void setEnabledUserInputs(boolean b) {
        this.nameTextField.setEnabled(b);
        this.addressTextField.setEnabled(b);
        this.phoneNumberTextField.setEnabled(b);
        this.numberOfEmployeesSpinner.setEnabled(b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel numberOfEmployeesLabel;
    private javax.swing.JSpinner numberOfEmployeesSpinner;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
