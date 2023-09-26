package main;

import controller.TaskViewController;
import model.TaskModel;
import view.TaskView;

public class TaskManagerMVC {
    
    public static void main(String[] args){
        TaskModel model = new TaskModel();
        TaskView view = new TaskView();
        TaskViewController controller = new TaskViewController(model, view);
        controller.startApp();
    }
}
