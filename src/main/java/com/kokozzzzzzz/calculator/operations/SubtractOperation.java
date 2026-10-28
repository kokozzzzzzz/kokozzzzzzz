package com.kokozzzzzzz.calculator.operations;

public class SubtractOperation implements Operations {
    @Override
    public double execute(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }
}
