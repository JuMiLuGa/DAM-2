package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Action;
import model.Task;
import model.TaskModel;
import view.TaskView;

public class TaskViewController {

    private final TaskModel model;
    private final TaskView view;

    public TaskViewController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;
        view.AddButtonActionListener(addTaskListener());
    }

    private ActionListener addTaskListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = view.getTaskDescription();
                if(!description.isEmpty()){
                    Task task = new Task(description);
                    model.addTask(task);
                    List<Task> tasks = model.getAllTasks();
                    view.updateTaskList(tasks);
                }
                
            }
        };
                return al;
    }
    public void startApp(){
        this.view.setVisible(true);
    }
}
