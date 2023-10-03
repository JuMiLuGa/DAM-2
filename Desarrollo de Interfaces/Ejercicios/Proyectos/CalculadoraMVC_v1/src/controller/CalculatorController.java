package controller;

import model.CalculatorModel;
import view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;

public class CalculatorController {

    private CalculatorModel model;
    private CalculatorView view;

    private Integer num1; // Declaración de num1
    private Integer num2; // Declaración de num2
    
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        view.addSevenButtonListener(new ButtonListener("7"));
        view.addEightButtonListener(new ButtonListener("8"));
        view.addNineButtonListener(new ButtonListener("9"));
        view.addSixButtonListener(new ButtonListener("6"));
        view.addFiveButtonListener(new ButtonListener("5"));
        view.addFourButtonListener(new ButtonListener("4"));
        view.addThreeButtonListener(new ButtonListener("3"));
        view.addTwoButtonListener(new ButtonListener("2"));
        view.addOneButtonListener(new ButtonListener("1"));
        view.addZeroButtonListener(new ButtonListener("0"));

        view.addMultiplyButtonListener(new OperatorButtonListener("*"));
        view.addSplitButtonListener(new OperatorButtonListener("/"));
        view.addSubtractButtonListener(new OperatorButtonListener("-"));
        view.addAdditionButtonListener(new OperatorButtonListener("+"));

        view.addClearButtonListener(new ClearButtonListener());
        view.addEqualButtonListener(new EqualButtonListener());
    }

    class ButtonListener implements ActionListener {

        private String digit;

        public ButtonListener(String digit) {
            this.digit = digit;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getLcdText();
            if(currentText != "0"){
                view.setLcdText(currentText + digit);
        } else if(currentText == "0"){
                view.setLcdText(digit);
            }
        }
    }

    // Add similar ActionListener classes for other buttons
    class ClearButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setLcdText("0");
        }
    }

    class EqualButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getLcdText();
            if (num1 != null && num2 != null) {
                model.setNum2(Integer.parseInt(currentText));
                int result = model.calculate();
                view.setLcdText(String.valueOf(result));
                num1 = result; // El resultado se convierte en num1 para futuras operaciones
            }
        }
    }

    class OperatorButtonListener implements ActionListener {

        private String operator;

        public OperatorButtonListener(String operator) {
            this.operator = operator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getLcdText();
            model.setNum1(Integer.parseInt(currentText));
            model.setOperator(operator);
            view.setLcdText("");
            
        }
    }

}
