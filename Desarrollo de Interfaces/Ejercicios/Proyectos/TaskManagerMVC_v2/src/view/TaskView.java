/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author maceira_barca_xian
 */
public class TaskView extends javax.swing.JFrame {

    /**
     * Creates new form TaskView
     */
    public TaskView() {
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

        taskDescriptionTextField = new javax.swing.JTextField();
        addTaskButton = new javax.swing.JButton();
        taskListScrollPane = new javax.swing.JScrollPane();
        taskList = new javax.swing.JList<>(new DefaultListModel());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taskDescriptionTextField.setText("");

        addTaskButton.setText("Add");

        taskListScrollPane.setViewportView(taskList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taskListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(taskDescriptionTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addTaskButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taskDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTaskButton))
                .addGap(18, 18, 18)
                .addComponent(taskListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    public String getTaskDescription() {
        return taskDescriptionTextField.getText();
    }
    
    public void addButtonListener(ActionListener listener) {
        addTaskButton.addActionListener(listener);
    }
    
    public void updateTaskList(List<String> tasks) {
        DefaultListModel listModel=(DefaultListModel) taskList.getModel();
        listModel.clear();
        for(String task: tasks) {
            listModel.addElement(task);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaskButton;
    private javax.swing.JTextField taskDescriptionTextField;
    private javax.swing.JList<String> taskList;
    private javax.swing.JScrollPane taskListScrollPane;
    // End of variables declaration//GEN-END:variables
}
