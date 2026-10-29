package com.kokozzzzzzz.calculator.history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HistoryManagerTest {
    private static final int TOTAL_ENTRIES = 11;
    private static final int MAX_SIZE = 10;

    private HistoryManager historyManager;

    @BeforeEach
    void setUp() {
        historyManager = new HistoryManager();
    }

    @Test
    void newHistoryIsEmpty() {
        assertTrue(historyManager.isEmpty());
    }

    @Test
    void historyIsNotEmptyAfterAddingEntry() {
        historyManager.addElement(new HistoryEntry(3, "+", 4, 7));

        assertFalse(historyManager.isEmpty());
    }

    @Test
    void historyKeepsOnlyLastTenEntries() {
        for (int i = 1; i <= TOTAL_ENTRIES; i++) {
            historyManager.addElement(new HistoryEntry(i, "+", 1, i + 1));
        }

        ArrayList<HistoryEntry> entries = historyManager.getHistory();

        assertEquals(MAX_SIZE, entries.size());
        assertEquals(2, entries.get(0).firstNumber(), 0.001);
        assertEquals(TOTAL_ENTRIES, entries.get(MAX_SIZE - 1).firstNumber(), 0.001);
    }

    @Test
    void clearMakesHistoryEmpty() {
        historyManager.addElement(new HistoryEntry(3, "+", 4, 7));
        historyManager.addElement(new HistoryEntry(7, "+", 4, 11));
        assertFalse(historyManager.isEmpty());

        historyManager.clear();

        assertTrue(historyManager.isEmpty());
    }

    @Test
    void getLastElementReturnsLastAddedEntry() {
        historyManager.addElement(new HistoryEntry(3, "*", 4, 12));
        historyManager.addElement(new HistoryEntry(7, "-", 4, 3));
        HistoryEntry last = new HistoryEntry(7, "+", 4, 11);
        historyManager.addElement(last);

        assertEquals(last, historyManager.getLastElement());
    }

    @Test
    void getLastElementKeepsNumbersAndOperator() {
        historyManager.addElement(new HistoryEntry(5, "/", 2, 2.5));

        HistoryEntry entry = historyManager.getLastElement();

        assertEquals(5, entry.firstNumber(), 0.001);
        assertEquals("/", entry.operator());
        assertEquals(2, entry.secondNumber(), 0.001);
        assertEquals(2.5, entry.result(), 0.001);
    }

    @Test
    void getLastElementOnEmptyHistoryThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> historyManager.getLastElement());
    }

    @Test
    void changingReturnedListDoesNotChangeHistory() {
        historyManager.addElement(new HistoryEntry(3, "+", 4, 7));

        ArrayList<HistoryEntry> copy = historyManager.getHistory();
        copy.add(new HistoryEntry(1, "+", 1, 2));

        assertEquals(1, historyManager.getHistory().size());
    }

    @Test
    void entryToStringHasExpectedFormat() {
        HistoryEntry entry = new HistoryEntry(5, "+", 3, 8);

        assertEquals("5.0 + 3.0 = 8.0", entry.toString());
    }
}