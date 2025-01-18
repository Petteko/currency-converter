package com.currencyconverter;

import com.currencyconverter.converter.ConversorMonedas;
import com.currencyconverter.api.UnsupportedCurrencyPairException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMonedas conversor = new ConversorMonedas();
        boolean exit = false;
        String[] currencies = {"ARS", "BRL", "CLP", "UYU", "USD", "EUR"};

        while (!exit) {
            // Display origin currency options
            System.out.println("Seleccione la moneda de origen:");
            for (int i = 1; i <= currencies.length; i++) {
                System.out.println(i + ". " + currencies[i - 1]);
            }

            // Read and validate origin selection
            int originSelection = readIntegerInput(scanner, 1, currencies.length);
            String originCurrency = currencies[originSelection - 1];

            // Create list of destination currencies excluding origin
            List<String> destinationCurrencies = new ArrayList<>();
            for (String currency : currencies) {
                if (!currency.equals(originCurrency)) {
                    destinationCurrencies.add(currency);
                }
            }

            // Display destination currency options
            System.out.println("Seleccione la moneda de destino:");
            for (int i = 1; i <= destinationCurrencies.size(); i++) {
                System.out.println(i + ". " + destinationCurrencies.get(i - 1));
            }

            // Read and validate destination selection
            int destinationSelection = readIntegerInput(scanner, 1, destinationCurrencies.size());
            String destinationCurrency = destinationCurrencies.get(destinationSelection - 1);

            // Read and validate amount
            double amount = readDoubleInput(scanner);

            // Perform conversion
            try {
                String resultado = conversor.convertir(originCurrency, destinationCurrency, amount);
                System.out.println(resultado);
            } catch (UnsupportedCurrencyPairException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Ask if the user wants to perform another conversion
            System.out.println("¿Desea realizar otra conversión? (si/no)");
            String anotherConversion = scanner.nextLine().toLowerCase();
            if (!anotherConversion.equals("si")) {
                exit = true;
            }
        }
        scanner.close();
    }

    // Helper method to read and validate integer input
    public static int readIntegerInput(Scanner scanner, int min, int max) {
        int selection = -1;
        while (selection < min || selection > max) {
            try {
                selection = Integer.parseInt(scanner.nextLine());
                if (selection < min || selection > max) {
                    System.out.println("Opción inválida. Por favor, ingrese un número entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        return selection;
    }

    // Helper method to read and validate double input
    public static double readDoubleInput(Scanner scanner) {
        double amount = -1;
        while (amount < 0) {
            try {
                amount = Double.parseDouble(scanner.nextLine());
                if (amount < 0) {
                    System.out.println("Monto inválido. Por favor, ingrese un número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        return amount;
    }
}