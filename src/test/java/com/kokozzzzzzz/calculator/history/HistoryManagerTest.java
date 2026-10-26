package com.kokozzzzzzz.calculator.history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HistoryManagerTest {
    private HistoryManager historyManager;

    @BeforeEach
    void preparation() {
        historyManager = new HistoryManager();
    }

    @Test
    void testCheckLastElementsRemain() {
        for (int i = 1; i <= 11; i++) {
            historyManager.addElement(String.valueOf(i));
        }
        ArrayList<String> entries = historyManager.getHistory();
        assertEquals("2", entries.get(0));
        assertEquals(10, entries.size());
    }

    @Test
    void testEmptyHistory() {
        assertThrows(IllegalStateException.class, () -> historyManager.getLastElement());
    }

    @Test
    void testResultLastRecord() {
        historyManager.addElement("3.0 + 4.0" + HistoryManager.SEPARATOR + "7.0");
        assertEquals("7.0", historyManager.getLastResult());
    }

    @Test
    void testClearHistory() {
        historyManager.addElement("3.0 + 4.0" + HistoryManager.SEPARATOR + "7.0");
        historyManager.addElement("7.0 + 4.0" + HistoryManager.SEPARATOR + "11.0");
        assertFalse(historyManager.isEmpty());
        historyManager.clear();
        assertTrue(historyManager.getHistory().isEmpty());
    }

    @Test
    void testCheckLastResult() {
        historyManager.addElement("3.0 * 4.0" + HistoryManager.SEPARATOR + "12.0");
        historyManager.addElement("7.0 - 4.0" + HistoryManager.SEPARATOR + "3.0");
        historyManager.addElement("7.0 + 4.0" + HistoryManager.SEPARATOR + "11.0");
        assertEquals("7.0 + 4.0" + HistoryManager.SEPARATOR + "11.0", historyManager.getLastElement());
    }

    @Test
    void testInvariabilityOfTheSize() {
        historyManager.addElement("3.0 + 4.0" + HistoryManager.SEPARATOR + "7.0");
        ArrayList<String> copy = historyManager.getHistory();
        copy.add("entry");
        assertEquals(1, historyManager.getHistory().size());
    }

    @Test
    void testLastResultWithEmptyHistory() {
        assertThrows(IllegalStateException.class, () -> historyManager.getLastResult());
    }

}

