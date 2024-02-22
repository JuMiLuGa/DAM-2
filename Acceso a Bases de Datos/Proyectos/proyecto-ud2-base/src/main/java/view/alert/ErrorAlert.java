package view.alert;

import java.awt.Component;
import javax.swing.JOptionPane;

public class ErrorAlert {
    public static void showError(String msg, Component parent) {
        JOptionPane.showMessageDialog(parent, msg, "Error", 0);
    }

    public static void showError(String msg) {
        showError(msg, null);
    }
}
