package com.kokozzzzzzz.calculator.calculator;

import com.kokozzzzzzz.calculator.operations.*;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static final String OPERATOR_PLUS = "+";
    private static final String OPERATOR_MINUS = "-";
    private static final String OPERATOR_MULTIPLY = "*";
    private static final String OPERATOR_DIVIDE = "/";
    private static final String OPERATOR_MODULO = "%";
    private static final String ERROR_UNKNOWN_OPERATOR = "неизвестный оператор";
     private static final Map<String, Operations> Operation = new HashMap<>();

    static {
        Operation.put(OPERATOR_PLUS, new AddOperation());
        Operation.put(OPERATOR_MINUS, new SubtractOperation());
        Operation.put(OPERATOR_MULTIPLY, new MultiplyOperation());
        Operation.put(OPERATOR_DIVIDE, new DivideOperation());
        Operation.put(OPERATOR_MODULO, new ModuloOperation());
    }

    public static double calculate(double firstNumber, double secondNumber, String operator) {
        Operations OPERATION = Operation.get(operator);
        if (OPERATION == null) {
            throw new IllegalArgumentException(ERROR_UNKNOWN_OPERATOR);
        }
        return OPERATION.execute(firstNumber, secondNumber);
    }
}
