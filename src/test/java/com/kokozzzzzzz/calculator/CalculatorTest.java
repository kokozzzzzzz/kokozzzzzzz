package com.kokozzzzzzz.calculator;

import com.kokozzzzzzz.calculator.calculator.Calculator;
import com.kokozzzzzzz.calculator.operations.*;
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
    void divideByZeroThrowsException() {
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
    void subtractResultReturnsCorrectResult() {
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

    @Test
    void addOperationWorks() {
        Operations operation = new AddOperation();
        assertEquals(8.0, operation.execute(5, 3), 0.001);
    }

    @Test
    void subtractOperationWorks() {
        Operations operation = new SubtractOperation();
        assertEquals(3.0, operation.execute(5, 2), 0.001);
    }

    @Test
    void multiplyOperationWorks() {
        Operations operation = new MultiplyOperation();
        assertEquals(15.0, operation.execute(5, 3), 0.001);
    }

    @Test
    void divideOperationWorks() {
        Operations operation = new DivideOperation();
        assertEquals(6, operation.execute(12, 2), 0.001);
    }

    @Test
    void divideByZeroByOperatorThrowsException() {
        Operations operation = new DivideOperation();
        assertThrows(ArithmeticException.class, () -> operation.execute(5, 0));
    }

    @Test
    void moduloOperationWorks() {
        Operations operation = new ModuloOperation();
        assertEquals(1, operation.execute(5, 2), 0.001);
    }

    @Test
    void moduloByZeroThrowsException() {
        Operations operation = new ModuloOperation();
        assertThrows(ArithmeticException.class, () -> operation.execute(5, 0));
    }

}