package com.kokozzzzzzz.calculator.calculator;

public class Calculator {
    private static final String OPERATOR_PLUS = "+";
    private static final String OPERATOR_MINUS = "-";
    private static final String OPERATOR_MULTIPLY = "*";
    private static final String OPERATOR_DIVIDE = "/";
    private static final String ERROR_UNKNOWN_OPERATOR = "неизвестный оператор";
    private static final String ERROR_DIVIDE_0 = "деление на ноль";

    public static double calculate(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case OPERATOR_PLUS:
                return firstNumber + secondNumber;
            case OPERATOR_MINUS:
                return firstNumber - secondNumber;
            case OPERATOR_DIVIDE:
                if (secondNumber == 0) {
                    throw new ArithmeticException(ERROR_DIVIDE_0);
                }
                return firstNumber / secondNumber;
            case OPERATOR_MULTIPLY:
                return firstNumber * secondNumber;
            default:
                throw new IllegalArgumentException(ERROR_UNKNOWN_OPERATOR);
        }
    }
}
