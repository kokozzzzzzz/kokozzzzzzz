package com.kokozzzzzzz.calculator;

import com.kokozzzzzzz.calculator.calculator.Calculator;
import com.kokozzzzzzz.calculator.history.HistoryEntry;
import com.kokozzzzzzz.calculator.history.HistoryManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static final String PROMPT = "> ";
    private static final int LEFT_PART = 0;
    private static final int RIGHT_PART = 2;
    private static final int OPERATOR_PART = 1;
    private static final int MAX_LENGTH = 3;
    private static final String ERROR = "Ошибка: ";
    private static final String DIVIDE_ON_THE_PARTS = "\\s+";
    private static final String FORMAT = ERROR + "неверный формат. Используйте: число оператор число";
    private static final String CALCULATION_RESULT = "Результат: ";
    private static final String HISTORY_IS_CLEANSED = "История очищена";
    private static final String EMPTY_HISTORY = "История пуста";
    private static final String DIVIDER = ") ";
    private static final String AVAILABLE_COMMANDS = "Доступные команды:\n" +
            "\n" +
            "<число> <оператор> <число>\n" +
            "\n" +
            "Операторы:\n" +
            "+  сложение\n" +
            "-  вычитание\n" +
            "*  умножение\n" +
            "/  деление\n" +
            "%  остаток от деления\n" +
            "\n" +
            "Дополнительные команды:\n" +
            "history  — показать историю\n" +
            "last     — повторить последнюю операцию\n" +
            "clear    — очистить историю\n" +
            "exit     — выход";
    private static final String HISTORY = "history";
    private static final String CLEAR = "clear";
    private static final String HELP = "help";
    private static final String EXIT_COMMAND = "exit";
    private static final String LAST_ENTRY = "last";

    public void run() {
        Scanner scanner = new Scanner(System.in);
        HistoryManager historyManager = new HistoryManager();
        while (true) {
            System.out.print(PROMPT);
            String input = scanner.nextLine().trim();
            if (input.equals(EXIT_COMMAND)) {
                break;
            }
            if (input.equals(CLEAR)) {
                historyManager.clear();
                System.out.println(HISTORY_IS_CLEANSED);
                continue;
            }
            if (input.equals(HELP)) {
                System.out.println(AVAILABLE_COMMANDS);
                continue;
            }
            if (input.equals(HISTORY)) {
                printHistory(historyManager);
                continue;
            }
            if (input.equals(LAST_ENTRY)) {
                repeatLast(historyManager);
                continue;
            }
            calculate(input, historyManager);
        }
    }

    private static void calculate(String input, HistoryManager historyManager) {
        String[] parts = input.split(DIVIDE_ON_THE_PARTS);
        if (parts.length != MAX_LENGTH) {
            System.out.println(FORMAT);
            return;
        }
        try {
            double firstNumber = Double.parseDouble(parts[LEFT_PART]);
            double secondNumber = Double.parseDouble(parts[RIGHT_PART]);
            String operator = parts[OPERATOR_PART];
            double result = Calculator.calculate(firstNumber, secondNumber, operator);
            historyManager.addElement(new HistoryEntry(firstNumber, operator, secondNumber, result));
            System.out.println(CALCULATION_RESULT + result);
        } catch (NumberFormatException e) {
            System.out.println(FORMAT);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(ERROR + e.getMessage());
        }
    }

    private static void repeatLast(HistoryManager historyManager) {
        try {
            HistoryEntry entry = historyManager.getLastElement();
            double result = Calculator.calculate(entry.firstNumber(), entry.secondNumber(), entry.operator());
            System.out.println(CALCULATION_RESULT + result);
        } catch (IllegalStateException | ArithmeticException | IllegalArgumentException e) {
            System.out.println(ERROR + e.getMessage());
        }
    }

    private static void printHistory(HistoryManager historyManager) {
        if (historyManager.isEmpty()) {
            System.out.println(EMPTY_HISTORY);
            return;
        }
        ArrayList<HistoryEntry> entries = historyManager.getHistory();
        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i + 1) + DIVIDER + entries.get(i));
        }
    }
}