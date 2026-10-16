package com.kokozzzzzzz.calculator;

import com.kokozzzzzzz.calculator.calculator.Calculator;

import java.util.Scanner;

public class Application {
    private static final String EXIT_COMMAND = "exit";
    private static final String PROMT = "> ";
    private static final int LEFT_PART = 0;
    private static final int RIGHT_PART = 2;
    private static final int OPERATOR_PART = 1;
    private static final String ERROR = "Ошибка: ";
    private static final String OPERATOR_EQUALS = "= ";
    private static final int MAX_LENGHT = 3;
    private static final String DIVIDE_ON_THE_PARTS = "\\s+";
    private static final String FORMAT = ERROR + "Ошибка: неверный формат. Используйте: число оператор число";

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(PROMT);
            String primer = scanner.nextLine().trim();
            if (primer.equals(EXIT_COMMAND)) {
                break;
            }
            String[] parts = primer.split(DIVIDE_ON_THE_PARTS);
            if (parts.length != MAX_LENGHT) {
                System.out.println(FORMAT);
                continue;
            }
            try {
                double firstNumber = Double.parseDouble(parts[LEFT_PART]);
                double secondNumber = Double.parseDouble(parts[RIGHT_PART]);
                String operator = parts[OPERATOR_PART];
                double result = Calculator.calculate(firstNumber, secondNumber, operator);
                System.out.println(firstNumber + " " + operator + " " + secondNumber + " " + OPERATOR_EQUALS + result);
            } catch (NumberFormatException e) {
                System.out.println(FORMAT);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }
}
