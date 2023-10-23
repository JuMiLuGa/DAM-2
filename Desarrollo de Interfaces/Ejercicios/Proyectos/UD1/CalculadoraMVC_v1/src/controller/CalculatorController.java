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

        num1 = null;
        num2 = null;

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
            if (view.isLCDTextCleared()) {
                // Si la pantalla LCD está limpia, establece el valor del dígito directamente
                view.setLcdText(digit);
                view.setLCDTextCleared(false);
            } else {
                view.setLcdText(currentText + digit);
            }
        }
    }

    // Add similar ActionListener classes for other buttons
    class ClearButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setLcdText("0");
            view.setLCDTextCleared(true); // Establecer como pantalla LCD limpia
        }
    }

   class EqualButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String currentText = view.getLcdText();
        if (num1 != null && num2 != null) {
            // Realizar la operación según el operador actual
            int result = 0;
            switch (model.getOperator()) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        // Manejar la división por cero si es necesario
                    }
                    break;
            }
            // Actualizar la pantalla LCD con el resultado
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
        
        if (num1 == null) {
            num1 = Integer.parseInt(currentText);
            model.setOperator(operator);
            view.setLcdText("");
        } else if (num2 == null) {
            num2 = Integer.parseInt(currentText);
            int result = model.calculate();
            view.setLcdText(String.valueOf(result));
            num1 = result;
            num2 = null;
            model.setOperator(operator);
        }
    }
}
    }

