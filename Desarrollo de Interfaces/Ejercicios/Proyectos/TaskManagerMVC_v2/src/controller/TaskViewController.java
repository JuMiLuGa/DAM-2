/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import model.TaskModel;
import view.TaskView;

/**
 *
 * @author maceira_barca_xian
 */
public class TaskViewController {

    private TaskModel model;
    private TaskView view;

    public TaskViewController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;
        this.view.addButtonListener(this.addTaskListener());
    }

    
    public void setVisible() {
        this.view.setVisible(true);
    }
    
    private void updateTaskList(){
        List taskList=new ArrayList();
        for (Task task : this.model.getAllTasks()) {
            taskList.add(task.getDescription());
        }
        this.view.updateTaskList(taskList);
        
    }
            
    private ActionListener addTaskListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = view.getTaskDescription();
                if (!description.isEmpty()) {
                    Task task = new Task(description);
                    model.addTask(task);
                    updateTaskList();
                }
            }
        };
        return al;
    }
    

}
