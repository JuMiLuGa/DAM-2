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
        taskList = new javax.swing.JList<>(new DefaultListModel());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addTaskjButton.setText("Añadir");

        taskDescriptionTextField.setText("");

        taskjScrollPane.setViewportView(taskList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(taskjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(taskDescriptionTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addTaskjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTaskjButton)
                    .addComponent(taskDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(taskjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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
