/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maceira_barca_xian
 */
public class TaskModel {
    private List<Task> tasks;

    public TaskModel() {
        this.tasks=new ArrayList<>();
    }
    
    public void addTask(Task task) {
        this.tasks.add(task);
    }
    
    public List<Task> getAllTasks(){
        return this.tasks;
    }
    
    
}
