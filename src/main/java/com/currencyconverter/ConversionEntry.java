package com.currencyconverter;

import java.time.LocalDateTime;

public class ConversionEntry {
    private String originCurrency;
    private String destinationCurrency;
    private double amount;
    private double convertedAmount;
    private LocalDateTime timestamp;

    public ConversionEntry(String originCurrency, String destinationCurrency, double amount, double convertedAmount) {
        this.originCurrency = originCurrency;
        this.destinationCurrency = destinationCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.timestamp = LocalDateTime.now();
    }

    // Getters y toString
    @Override
    public String toString() {
        return String.format("[%s] %s a %s: %.2f %s = %.2f %s",
                timestamp, originCurrency, destinationCurrency, amount, originCurrency, convertedAmount, destinationCurrency);
    }
}