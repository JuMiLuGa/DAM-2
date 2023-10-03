package main;

import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        view.setVisible(true);
    }
}

