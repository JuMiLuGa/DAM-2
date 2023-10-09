// CalculatorModel.java
package model;

public class CalculatorModel {
    private int num1;
    private int num2;
    private String operator;

    public void setNum1(int num) {
        num1 = num;
    }

    public void setNum2(int num) {
        num2 = num;
    }

    public int calculate() {
        int result = 0;
        if (operator != null) {
            switch (operator) {
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
                    if (num2 != 0.0) {
                        result = num1 / num2;
                    }
                    break;
            }
        }
        return result;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    
    public void clear() {
        num1 = 0;
        num2 = 0;
        operator = null;
    }
    
    public int getNum2() {
    return num2;
}

    public int getNum1() {
        return num1;
    }

    public String getOperator() {
        return operator;
    }

}
