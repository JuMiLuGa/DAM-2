package view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import model.Task;

public class TaskView extends javax.swing.JFrame {

    public TaskView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addTaskjButton = new javax.swing.JButton();
        taskDescriptionTextField = new javax.swing.JTextField();
        taskjScrollPane = new javax.swing.JScrollPane();
        taskList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addTaskjButton.setText("add");

        taskDescriptionTextField.setText("");

        taskjScrollPane.setViewportView(taskList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taskjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(taskDescriptionTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addTaskjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTaskjButton)
                    .addComponent(taskDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void AddButtonActionListener(ActionListener listener){
        addTaskjButton.addActionListener(listener);
    }
    
    public String getTaskDescription(){
        return taskDescriptionTextField.getText();
    }
    
    public void updateTaskList(List<Task> tasks){
        DefaultListModel listModel = (DefaultListModel) taskList.getModel();
        listModel.clear();
        for(Task task : tasks){
            listModel.addElement(task.getDescription());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaskjButton;
    private javax.swing.JTextField taskDescriptionTextField;
    private javax.swing.JList<String> taskList;
    private javax.swing.JScrollPane taskjScrollPane;
    // End of variables declaration//GEN-END:variables
}
