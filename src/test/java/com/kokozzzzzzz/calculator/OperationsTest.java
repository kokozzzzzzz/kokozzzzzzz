package com.kokozzzzzzz.calculator;

import com.kokozzzzzzz.calculator.operations.AddOperation;
import com.kokozzzzzzz.calculator.operations.DivideOperation;
import com.kokozzzzzzz.calculator.operations.ModuloOperation;
import com.kokozzzzzzz.calculator.operations.MultiplyOperation;
import com.kokozzzzzzz.calculator.operations.Operations;
import com.kokozzzzzzz.calculator.operations.SubtractOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationsTest {

    @Test
    void addOperationReturnsSum() {
        Operations operation = new AddOperation();
        assertEquals(8.0, operation.execute(5, 3), 0.001);
    }

    @Test
    void subtractOperationReturnsDifference() {
        Operations operation = new SubtractOperation();
        assertEquals(3.0, operation.execute(5, 2), 0.001);
    }

    @Test
    void multiplyOperationReturnsProduct() {
        Operations operation = new MultiplyOperation();
        assertEquals(15.0, operation.execute(5, 3), 0.001);
    }

    @Test
    void divideOperationReturnsQuotient() {
        Operations operation = new DivideOperation();
        assertEquals(6.0, operation.execute(12, 2), 0.001);
    }

    @Test
    void divideOperationByZeroThrowsArithmeticException() {
        Operations operation = new DivideOperation();
        assertThrows(ArithmeticException.class, () -> operation.execute(5, 0));
    }

    @Test
    void moduloOperationReturnsRemainder() {
        Operations operation = new ModuloOperation();
        assertEquals(1.0, operation.execute(5, 2), 0.001);
    }

    @Test
    void moduloOperationByZeroThrowsArithmeticException() {
        Operations operation = new ModuloOperation();
        assertThrows(ArithmeticException.class, () -> operation.execute(5, 0));
    }
}