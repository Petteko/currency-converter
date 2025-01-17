package com.currencyconverter.api;

public class UnsupportedCurrencyPairException extends Exception {
    public UnsupportedCurrencyPairException(String message) {
        super(message);
    }
}