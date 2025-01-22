package com.currencyconverter;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
    private List<ConversionEntry> history;
    private final String logDirectory = "logs";
    private final String sessionId;

    public ConversionHistory() {
        history = new ArrayList<>();
        sessionId = generateSessionId();
        createLogDirectory();
    }

    private String generateSessionId() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    }

    private void createLogDirectory() {
        File directory = new File(logDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
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

    public void saveHistoryToFile() {
        if (!history.isEmpty()) {
            String filename = String.format("%s/conversiones_%s.log", logDirectory, sessionId);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write("=== Historial de Conversiones ===\n");
                for (ConversionEntry entry : history) {
                    writer.write(entry.toString() + "\n");
                }
                System.out.println("\nHistorial guardado en: " + filename);
            } catch (IOException e) {
                System.err.println("Error al guardar el historial: " + e.getMessage());
            }
        }
    }
}