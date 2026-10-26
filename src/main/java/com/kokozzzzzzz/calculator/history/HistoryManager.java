package com.kokozzzzzzz.calculator.history;

import java.util.ArrayList;

public class HistoryManager {
    private static final int MAX_HISTORY_SIZE = 10;
    private static final String ERROR_EMPTY_STRING = "История пуста";
    public static final String SEPARATOR = " = ";
    private final ArrayList<String> history = new ArrayList<>();

    public  void addElement(String entry) {
        history.add(entry);
        while (history.size() > MAX_HISTORY_SIZE) {
            history.remove(0);
        }
    }
    public void clear() {
        history.clear();
    }
    public ArrayList<String> getHistory() {
        return new ArrayList<>(history);
    }
    public boolean isEmpty(){
        return history.isEmpty();
    }
    public String getLastElement(){
        if (history.isEmpty()){
            throw new IllegalStateException(ERROR_EMPTY_STRING);
        }
       return history.getLast();
    }
    public String getLastResult(){
        String entry = getLastElement();
        return entry.substring(entry.lastIndexOf(SEPARATOR)+ SEPARATOR.length());
    }
}