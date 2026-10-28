package com.kokozzzzzzz.calculator.operations;

public class MultiplyOperation implements Operations {
    @Override
    public double execute(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}
