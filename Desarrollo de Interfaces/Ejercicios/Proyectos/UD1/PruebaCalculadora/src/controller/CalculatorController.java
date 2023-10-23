package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        view.addOneButtonListener(new OneButtonListener());
        view.addTwoButtonListener(new TwoButtonListener());
        view.addThreeButtonListener(new ThreeButtonListener());
        view.addFourButtonListener(new FourButtonListener());
        view.addFiveButtonListener(new FiveButtonListener());
        view.addSixButtonListener(new SixButtonListener());
        view.addSevenButtonListener(new SevenButtonListener());
        view.addEightButtonListener(new EightButtonListener());
        view.addNineButtonListener(new NineButtonListener());
        view.addZeroButtonListener(new ZeroButtonListener());

        view.addAdditionButtonListener(new AdditionButtonListener());
        view.addSubtractButtonListener(new SubtractButtonListener());
        view.addMultiplyButtonListener(new MultiplyButtonListener());
        view.addSplitButtonListener(new SplitButtonListener());

        view.addClearButtonListener(new ClearButtonListener());
        view.addEqualButtonListener(new EqualButtonListener());
    }

    class OneButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleNumericButtonClick("1");
        }
    }

    class TwoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleNumericButtonClick("2");
        }
    }

    class ThreeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleNumericButtonClick("3");
        }
    }

    class FourButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleNumericButtonClick("4");
        }
    }

    class FiveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleNumericButtonClick("5");
        }
    }

    class SixButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleNumericButtonClick("6");
        }
    }

    class SevenButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleNumericButtonClick("7");
        }
    }

    class EightButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleNumericButtonClick("8");
        }
    }

    class NineButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleNumericButtonClick("9");
        }
    }

    class ZeroButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleNumericButtonClick("0");
        }
    }

    class AdditionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleOperatorButtonClick("+");
        }
    }

    class SubtractButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleOperatorButtonClick("-");
        }
    }

    class MultiplyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleOperatorButtonClick("*");
        }
    }

    class SplitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleOperatorButtonClick("/");
        }
    }

    class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.clear();
            view.setLcdText("");
            view.setLCDTextCleared(true);
        }
    }

    class EqualButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getLcdText();
            model.setNum2(Integer.parseInt(currentText));
            int result = model.calculate();
            view.setLcdText(String.valueOf(result));
        }
    }

    private void handleNumericButtonClick(String number) {
        if (view.isLCDTextCleared()) {
            view.setLcdText(number);
            view.setLCDTextCleared(false);
        } else {
            String currentText = view.getLcdText();
            view.setLcdText(currentText + number);
        }
    }

    private void handleOperatorButtonClick(String operator) {
        String currentText = view.getLcdText();
        model.setNum1(Integer.parseInt(currentText));
        model.setOperator(operator);
        view.setLcdText("");
    }
}
