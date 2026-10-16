package com.kokozzzzzzz.calculator;

import com.kokozzzzzzz.calculator.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {


    @Test
    void plusReturnsCorrectResult() {
        double firstNumber = 5;
        double secondNumber = 3;
        double result = Calculator.calculate(firstNumber, secondNumber, "+");
        assertEquals(8.0, result, 0.001);
    }

    @Test
    void minusReturnsCorrectResult() {
        double firstNumber = 10;
        double secondNumber = 3;
        double result = Calculator.calculate(firstNumber, secondNumber, "-");
        assertEquals(7.0, result, 0.001);
    }

    @Test
    void multiplyReturnsCorrectResult() {
        double firstNumber = 4;
        double secondNumber = 3;
        double result = Calculator.calculate(firstNumber, secondNumber, "*");
        assertEquals(12.0, result, 0.001);
    }

    @Test
    void divideReturnsCorrectResult() {
        double firstNumber = 9;
        double secondNumber = 3;
        double result = Calculator.calculate(firstNumber, secondNumber, "/");
        assertEquals(3, result, 0.001);
    }

    @Test
    void dividebyZeroThrowsException() {
        double firstNumber = 4;
        double secondNumber = 0;
        assertThrows(ArithmeticException.class, () -> Calculator.calculate(firstNumber, secondNumber, "/"));
    }

    @Test
    void unknownOperatorThrowsException() {
        double firstNumber = 9;
        double secondNumber = 2;
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(firstNumber, secondNumber, "^"));
    }

    @Test
    void fracitonalResultRetrunCorrectResult() {
        double firstNumber = 10;
        double secondNumber = 4;
        double result = Calculator.calculate(firstNumber, secondNumber, "/");
        assertEquals(2.5, result, 0.001);
    }

    @Test
    void negativeResultReturnsCorrectResult() {
        double firstNumber = -5;
        double secondNumber = 3;
        double result = Calculator.calculate(firstNumber, secondNumber, "-");
        assertEquals(-8.0, result, 0.001);
    }

    @Test
    void zeroResultReturnsCorrectResult() {
        double firstNumber = 0;
        double secondNumber = 5;
        double result = Calculator.calculate(firstNumber, secondNumber, "/");
        assertEquals(0.0, result, 0.001);
    }
}