package com.kokozzzzzzz.calculator.history;

public record HistoryEntry(double firstNumber, String operator, double secondNumber, double result) {

    @Override
    public String toString() {
        return firstNumber + " " + operator + " " + secondNumber + " = " + result;
    }
}
