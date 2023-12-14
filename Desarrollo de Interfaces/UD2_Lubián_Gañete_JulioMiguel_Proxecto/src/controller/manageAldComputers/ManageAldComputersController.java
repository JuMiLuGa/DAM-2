/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.manageAldComputers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import model.aldComputerService.AldComputerService;
import model.aldComputerService.Computer;
import model.aldComputerService.ComputerType;
import view.aldComputers.ManageAldComputersDialog;

/**
 *
 * @author fermigo
 */
public class ManageAldComputersController {

    private final ManageAldComputersDialog view;
    private final AldComputerService model;

    public ManageAldComputersController(ManageAldComputersDialog view, AldComputerService model) {
        this.view = view;
        this.model = model;
        this.view.addAddButtonActionListener(this.getAddButtonActionListener());
        this.view.addEditButtonActionListener(this.getEditButtonActionListener());
        this.view.addDeleteButtonActionListener(this.getDeleteButtonActionListener());
        this.view.addTableModelListener(this.getTableModelListener());
        this.addDefaultComputersToTable();
        this.view.getComputerTable().getSelectionModel().addListSelectionListener(this.getListSelectionListener());
        this.view.addSaveButtonActionListener(this.getSaveButtonActionListener());
        this.view.addCancelButtonActionListener(this.getCancelButtonActionListener());
        this.view.addAddComputerButtonActionListener(this.getAddComputerButtonActionListener());
        this.view.changeComboBoxModel(this.fillComboBox());
    }

    private TableModelListener getTableModelListener() {
        TableModelListener tl = new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE) {
                    int row = tme.getFirstRow();
                    int col = tme.getColumn();
                    String data = view.getCellInfo(row, col);
                }
            }
        };
        return tl;
    }

    private ActionListener getCancelButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setSerialTextField("");
                view.setBrandTextField("");
                view.setModelTextField("");
                view.enableTextFields(false);
                view.enableCombobox(false);

                view.setVisibleAddComputerButton(false);
                view.setVisibleCancelComputerButton(false);
                view.setVisibleSaveComputerButton(false);
            }
        };
        return al;
    }

    private ActionListener getAddButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                view.setSerialTextField("");
                view.setBrandTextField("");
                view.setModelTextField("");
                view.enableCombobox(true);
                view.enableTextFields(true);
                view.setVisibleAddComputerButton(true);
                view.setVisibleCancelComputerButton(true);
                view.setVisibleSaveComputerButton(false);

            }
        };
        return al;
    }

    private void addDefaultComputersToTable() {
        for (Computer comp : model.getComputers()) {
            System.out.println(comp);
            this.addComputer(comp);
        }
    }

    private void addComputer(Computer computer) {
        DefaultTableModel tableModel = (DefaultTableModel) this.view.getComputersTableModel();
        Object[] computerData = new Object[]{
            computer.getSerial(), computer.getBrand(), computer.getModel()
        };
        tableModel.addRow(computerData);

    }

    private ListSelectionListener getListSelectionListener() {
        ListSelectionListener listener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = view.getComputerTable().getSelectedRow();
                    if (selectedRow != -1) {
                        // Obtener datos de la fila seleccionada
                        String serial = view.getCellInfo(selectedRow, 0);
                        Computer computer = model.getSelectedComputers(serial);
                        String brand = view.getCellInfo(selectedRow, 1);
                        String model = view.getCellInfo(selectedRow, 2);

                        // Mostrar los datos en los JTextField
                        view.selectInComboBox(computer.getComputerType().ordinal());
                        view.setSerialTextField(serial);
                        view.setBrandTextField(brand);
                        view.setModelTextField(model);
                    }
                }
            }
        };
        return listener;
    }

    private ActionListener getSaveButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos de los campos de texto
                String serial = view.getSerialTextField().getText();
                String brand = view.getBrandTextField().getText();
                String model = view.getModelTextField().getText();

                // Obtener la fila seleccionada
                int selectedRow = view.getComputerTable().getSelectedRow();

                if (selectedRow != -1) {
                    // Modificar los datos en la tabla
                    view.modifyTableRow(selectedRow, serial, brand, model);
                }
                view.enableTextFields(false);
                view.enableCombobox(false);
                view.setVisibleAddComputerButton(false);
                view.setVisibleCancelComputerButton(false);
                view.setVisibleSaveComputerButton(false);
            }
        };
        return al;
    }

    private ActionListener getEditButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                view.enableCombobox(true);
                view.enableTextFields(true);

                view.setVisibleAddComputerButton(false);
                view.setVisibleCancelComputerButton(true);
                view.setVisibleSaveComputerButton(true);
            }
        };
        return al;
    }

    public DefaultComboBoxModel<String> fillComboBox() {
        DefaultComboBoxModel<String> dcmbm = new DefaultComboBoxModel<>();
        for (ComputerType comp : ComputerType.values()) {
            dcmbm.addElement(comp.toString());
        }
        return dcmbm;
    }

    private ActionListener getAddComputerButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String serial = view.getSerialTextField().getText();
                String brand = view.getBrandTextField().getText();
                String model = view.getModelTextField().getText();

                // Agregar una nueva fila con los datos a la tabla
                addRowToTable(serial, brand, model);
                
                view.setSerialTextField("");
                view.setBrandTextField("");
                view.setModelTextField("");
                view.enableTextFields(false);
                view.enableCombobox(false);
                view.setVisibleAddComputerButton(false);
                view.setVisibleCancelComputerButton(false);
                view.setVisibleSaveComputerButton(false);
            }
        };
        return al;
    }

    private void addRowToTable(String serial, String brand, String model) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getComputersTableModel();
        Object[] rowData = new Object[]{serial, brand, model};
        tableModel.addRow(rowData);
    }
    
    private ActionListener getDeleteButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la fila seleccionada
                int selectedRow = view.getComputerTable().getSelectedRow();

                // Verificar si hay una fila seleccionada
                if (selectedRow != -1) {
                    // Eliminar la fila seleccionada
                    deleteSelectedRow(selectedRow);
                }

            }

        };
        return al;
    }

    private void deleteSelectedRow(int rowIndex) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getComputersTableModel();
        tableModel.removeRow(rowIndex);
    }

}
