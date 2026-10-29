package com.kokozzzzzzz.calculator;

import com.kokozzzzzzz.calculator.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void plusReturnsCorrectResult() {
        assertEquals(8.0, Calculator.calculate(5, 3, "+"), 0.001);
    }

    @Test
    void minusReturnsCorrectResult() {
        assertEquals(7.0, Calculator.calculate(10, 3, "-"), 0.001);
    }

    @Test
    void minusReturnsNegativeResult() {
        assertEquals(-8.0, Calculator.calculate(-5, 3, "-"), 0.001);
    }

    @Test
    void multiplyReturnsCorrectResult() {
        assertEquals(12.0, Calculator.calculate(4, 3, "*"), 0.001);
    }

    @Test
    void divideReturnsCorrectResult() {
        assertEquals(3.0, Calculator.calculate(9, 3, "/"), 0.001);
    }

    @Test
    void divideReturnsFractionalResult() {
        assertEquals(2.5, Calculator.calculate(10, 4, "/"), 0.001);
    }

    @Test
    void divideZeroByNumberReturnsZero() {
        assertEquals(0.0, Calculator.calculate(0, 5, "/"), 0.001);
    }

    @Test
    void divideByZeroThrowsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> Calculator.calculate(4, 0, "/"));
    }

    @Test
    void moduloReturnsCorrectResult() {
        assertEquals(1.0, Calculator.calculate(10, 3, "%"), 0.001);
    }

    @Test
    void moduloByZeroThrowsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> Calculator.calculate(10, 0, "%"));
    }

    @Test
    void unknownOperatorThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(9, 2, "^"));
    }
}