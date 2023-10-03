package model;

public class CalculatorModel {
    private Integer num1;
    private Integer num2;
    private String operator;

    public void setNum1(Integer num) {
        num1 = num;
    }

    public void setNum2(Integer num) {
        num2 = num;
    }

    public Integer getNum1() {
        return num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int calculate() {
        int result = 0;
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
                result = num1 / num2;
                break;
        }
        return result;
    }
}
