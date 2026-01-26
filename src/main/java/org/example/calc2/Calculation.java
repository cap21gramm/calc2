package org.example.calc2;

public class Calculation {
    private double num1;
    private double num2;
    private String operation;
    private double result;

    public Calculation(double num1, double num2, String operation, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getOperation() {
        return operation;
    }

    public double getResult() {
        return result;
    }

    public String getOperationSymbol() {
        switch (operation) {
            case "sum":
                return "+";
            case "minus":
                return "-";
            case "umnoj":
                return "×";
            case "delenie":
                return "÷";
            default:
                return operation;
        }
    }

    @Override
    public String toString() {
        return num1 + " " + getOperationSymbol() + " " + num2 + " = " + result;
    }
}