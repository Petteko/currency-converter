package com.currencyconverter;

import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
    private List<ConversionEntry> history;

    public ConversionHistory() {
        history = new ArrayList<>();
    }

    public void addEntry(ConversionEntry entry) {
        history.add(entry);
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
        } else {
            System.out.println("\n=== Historial de Conversiones ===");
            for (ConversionEntry entry : history) {
                System.out.println(entry);
            }
        }
    }
}