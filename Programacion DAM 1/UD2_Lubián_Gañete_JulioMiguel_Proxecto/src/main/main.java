package main;

import controller.mainJDialogController;
import view.MainJDialog;

public class main {
    public static void main(String[] args) {
        MainJDialog mainview = new MainJDialog();
        mainJDialogController fc = new mainJDialogController(mainview);
        mainview.setVisible(true);
    }
}
