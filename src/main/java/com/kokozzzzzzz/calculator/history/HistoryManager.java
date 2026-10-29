package com.kokozzzzzzz.calculator.history;

import java.util.ArrayList;

public class HistoryManager {
    private static final int MAX_HISTORY_SIZE = 10;
    private static final String ERROR_EMPTY_HISTORY = "История пуста";
    private final ArrayList<HistoryEntry> history = new ArrayList<>();

    public void addElement(HistoryEntry entry) {
        history.add(entry);
        while (history.size() > MAX_HISTORY_SIZE) {
            history.remove(0);
        }
    }

    public void clear() {
        history.clear();
    }

    public ArrayList<HistoryEntry> getHistory() {
        return new ArrayList<>(history);
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public HistoryEntry getLastElement() {
        if (history.isEmpty()) {
            throw new IllegalStateException(ERROR_EMPTY_HISTORY);
        }
        return history.getLast();
    }
}