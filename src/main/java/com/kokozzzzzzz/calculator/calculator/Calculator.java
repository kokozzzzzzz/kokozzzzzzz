package com.kokozzzzzzz.calculator.calculator;

import com.kokozzzzzzz.calculator.operations.AddOperation;
import com.kokozzzzzzz.calculator.operations.DivideOperation;
import com.kokozzzzzzz.calculator.operations.ModuloOperation;
import com.kokozzzzzzz.calculator.operations.MultiplyOperation;
import com.kokozzzzzzz.calculator.operations.Operations;
import com.kokozzzzzzz.calculator.operations.SubtractOperation;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static final String OPERATOR_PLUS = "+";
    private static final String OPERATOR_MINUS = "-";
    private static final String OPERATOR_MULTIPLY = "*";
    private static final String OPERATOR_DIVIDE = "/";
    private static final String OPERATOR_MODULO = "%";
    private static final String ERROR_UNKNOWN_OPERATOR = "неизвестный оператор";
    private static final Map<String, Operations> operations = new HashMap<>();

    static {
        operations.put(OPERATOR_PLUS, new AddOperation());
        operations.put(OPERATOR_MINUS, new SubtractOperation());
        operations.put(OPERATOR_MULTIPLY, new MultiplyOperation());
        operations.put(OPERATOR_DIVIDE, new DivideOperation());
        operations.put(OPERATOR_MODULO, new ModuloOperation());
    }

    public static double calculate(double firstNumber, double secondNumber, String operator) {
        Operations operation = operations.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException(ERROR_UNKNOWN_OPERATOR);
        }
        return operation.execute(firstNumber, secondNumber);
    }
}