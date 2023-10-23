package model;

import java.util.ArrayList;
import java.util.List;

public class TaskModel {

    private List<Task> tasks;

    public TaskModel() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return this.tasks;
    }

}
