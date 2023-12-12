/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import view.table.TableDialog;

/**
 *
 * @author fermigo
 */
public class TableController {

    private final TableDialog view;

    public TableController(TableDialog view) {
        this.view = view;
        this.view.addAddUserButtonActionListener(this.getAddUserButtonActionListener());
        this.view.addGetInfoButtonActionListener(this.getGetInfoButtonActionListener());
        this.view.addClearTableButtonActionListener(this.getClearTableButtonActionListener());
        this.view.addTableModelListener(this.getTableModelListener());
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
                Random rn = new Random();
                int id = rn.nextInt();
                row.add(id);
                row.add("User Name");
                row.add("User Surname");
                view.addRowTable(row);
            }
        };
        return al;
    }

    private ActionListener getGetInfoButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = view.getCellInfo();
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

}
