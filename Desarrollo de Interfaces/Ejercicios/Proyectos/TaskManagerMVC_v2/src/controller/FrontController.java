/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.TaskModel;
import view.TaskView;

/**
 *
 * @author maceira_barca_xian
 */
public class FrontController {

    private final TaskModel model;
    private final TaskView view;

    public FrontController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;
        setTaskViewController(model, view);
    }

    private void setTaskViewController(TaskModel model, TaskView view) {
        TaskViewController tc = new TaskViewController(model, view);
        tc.setVisible();
    }

}
