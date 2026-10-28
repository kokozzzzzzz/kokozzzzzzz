package com.kokozzzzzzz.calculator.operations;

public interface Operations {
    static final String ERROR_DIVIDE_BY_ZERO = "Деление на ноль";
    double execute(double firstNumber, double secondNumber);
}
