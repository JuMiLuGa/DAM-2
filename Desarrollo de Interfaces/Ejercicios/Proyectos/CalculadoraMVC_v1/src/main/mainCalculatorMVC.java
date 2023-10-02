package main;

import view.CalculatorView;
import javax.swing.JFrame;

public class mainCalculatorMVC {
    public static void main(String[] args){
        
        CalculatorView cv = new CalculatorView();
        cv.setTitle("Calculator");
        cv.setVisible(true);
    }
}
