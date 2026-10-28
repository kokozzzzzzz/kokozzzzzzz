package com.kokozzzzzzz.calculator.operations;

public class DivideOperation implements Operations {

    @Override
    public double execute(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException(ERROR_DIVIDE_BY_ZERO);
        }
        return firstNumber / secondNumber;
    }
}
