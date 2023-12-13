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
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import model.aldComputerService.AldComputerService;
import model.aldComputerService.Computer;
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
        this.view.addAddButtonActionListener(this.getAddUserButtonActionListener());
        //this.view.addEditButtonActionListener(this.getGetInfoButtonActionListener());
        //this.view.addDeleteButtonActionListener(this.getClearTableButtonActionListener());
        this.view.addTableModelListener(this.getTableModelListener());
        this.addDefaultComputersToTable();
        
    }

    private TableModelListener getTableModelListener() {
        TableModelListener tl = new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE) {
                    int row = tme.getFirstRow();
                    int col = tme.getColumn();
                    String data = view.getCellInfo(row, col);
                    JOptionPane.showMessageDialog(view, "Modified value at row " + (row + 1) + " col " + (col + 1) + ": " + data);
                }
            }
        };
        return tl;
    }

    private ActionListener getAddUserButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector row = new Vector();
                
            }
        };
        return al;
    }
    
    private void addDefaultComputersToTable(){
        for(Computer comp : model.getComputers()){
            System.out.println(comp);
            this.addComputer(comp);
        }
    }
    
    private void addComputer(Computer computer){
        DefaultTableModel tableModel = (DefaultTableModel) this.view.getComputersTableModel();
        Object[] computerData = new Object[]{
            computer.getSerial(),computer.getBrand(), computer.getModel()
        };
        tableModel.addRow(computerData);
        
        this.view.addComputersTableModel(tableModel);
        
    }
/*
    private ActionListener getGetInfoButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String info = view.getCellInfo();
                JOptionPane.showMessageDialog(view, info);
            }
        };
        return al;
    }

    private ActionListener getClearTableButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearTable();
            }
        };
        return al;
    }
*/
}
