package main;

import controller.TaskManagerController;
import model.TaskModel;
import view.TaskView;

public class TaskManagerMVC {
    
    public static void main(String[] args){
        TaskModel model = new TaskModel();
        TaskView view = new TaskView();
        TaskManagerController controller = new TaskManagerController(model, view);
        controller.startApp();
    }
}
