package com.currencyconverter; // Add this package declaration

import com.currencyconverter.converter.ConversorMonedas; // Import ConversorMonedas
import com.currencyconverter.api.UnsupportedCurrencyPairException; // Import the exception
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMonedas conversor = new ConversorMonedas();
        boolean exit = false;

        while (!exit) {
            // Display currency options
            System.out.println("Bienvenido al Conversor de Monedas");
            System.out.println("Monedas soportadas:");
            System.out.println("- ARS: Peso argentino");
            System.out.println("- BRL: Real brasileño");
            System.out.println("- CLP: Peso chileno");
            System.out.println("- UYU: Peso uruguayo");
            System.out.println("- USD: Dólar estadounidense");
            System.out.println("- EUR: Euro");
            System.out.println("Ingrese 'list' para ver las monedas nuevamente o 'exit' para salir.");

            // Get user input for origin currency
            System.out.print("Ingrese la moneda de origen: ");
            String monedaOrigen = scanner.nextLine().toUpperCase();
            if (monedaOrigen.equals("EXIT")) {
                break;
            } else if (monedaOrigen.equals("LIST")) {
                continue;
            }

            // Get user input for destination currency
            System.out.print("Ingrese la moneda de destino: ");
            String monedaDestino = scanner.nextLine().toUpperCase();
            if (monedaDestino.equals("EXIT")) {
                break;
            } else if (monedaDestino.equals("LIST")) {
                continue;
            }

            // Get user input for amount
            System.out.print("Ingrese el monto: ");
            double monto;
            try {
                monto = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Monto inválido. Intente nuevamente.");
                continue;
            }

            // Perform conversion
            try {
                String resultado = conversor.convertir(monedaOrigen, monedaDestino, monto);
                System.out.println(resultado);
            } catch (UnsupportedCurrencyPairException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}