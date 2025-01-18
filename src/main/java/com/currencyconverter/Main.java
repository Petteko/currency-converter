package com.currencyconverter;

import com.currencyconverter.converter.ConversorMonedas;
import com.currencyconverter.api.UnsupportedCurrencyPairException;
import java.util.Scanner;

public class Main {
    private static final String[] CURRENCIES = {"ARS", "BRL", "CLP", "UYU", "USD", "EUR"};
    private static final Scanner scanner = new Scanner(System.in);
    private static final ConversorMonedas conversor = new ConversorMonedas();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            // Mostrar menú principal
            System.out.println("\n=== Conversor de Monedas ===");
            System.out.println("1. Realizar una conversión");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            int option = readIntegerInput(1, 2);

            switch (option) {
                case 1:
                    performConversion();
                    break;
                case 2:
                    exit = true;
                    System.out.println("Gracias por usar el Conversor de Monedas. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    // Método para realizar una conversión
    private static void performConversion() {
        boolean anotherConversion = true;

        while (anotherConversion) {
            // Seleccionar moneda de origen
            System.out.println("\nSeleccione la moneda de origen:");
            String originCurrency = selectCurrency();

            // Seleccionar moneda de destino
            System.out.println("\nSeleccione la moneda de destino:");
            String destinationCurrency = selectCurrency();

            // Validar que las monedas sean diferentes
            if (originCurrency.equals(destinationCurrency)) {
                System.out.println("Error: Las monedas de origen y destino no pueden ser iguales.");
                continue;
            }

            // Ingresar el monto a convertir
            System.out.print("\nIngrese el monto a convertir: ");
            double amount = readDoubleInput();

            // Realizar la conversión
            try {
                String resultado = conversor.convertir(originCurrency, destinationCurrency, amount);
                System.out.println("\n=== Resultado de la Conversión ===");
                System.out.println(originCurrency + " a " + destinationCurrency + ":");
                System.out.println(amount + " " + originCurrency + " = " + resultado); // Resultado limpio
            } catch (UnsupportedCurrencyPairException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Preguntar si desea realizar otra conversión
            System.out.println("\nPresione Enter para realizar otra conversión o escriba 'exit' para salir.");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                anotherConversion = false;
            }
        }
    }
    // Método para seleccionar una moneda
    private static String selectCurrency() {
        // Mostrar opciones de monedas
        for (int i = 0; i < CURRENCIES.length; i++) {
            System.out.println((i + 1) + ". " + CURRENCIES[i]);
        }

        // Leer y validar la selección del usuario
        int selection = readIntegerInput(1, CURRENCIES.length);
        String selectedCurrency = CURRENCIES[selection - 1];
        System.out.println("Moneda seleccionada: " + selectedCurrency);
        return selectedCurrency;
    }

    // Método para leer y validar una entrada entera
    private static int readIntegerInput(int min, int max) {
        int input = -1;
        while (input < min || input > max) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max) {
                    System.out.print("Opción no válida. Ingrese un número entre " + min + " y " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número: ");
            }
        }
        return input;
    }

    // Método para leer y validar una entrada de tipo double
    private static double readDoubleInput() {
        double input = -1;
        while (input < 0) {
            try {
                input = Double.parseDouble(scanner.nextLine());
                if (input < 0) {
                    System.out.print("Monto inválido. Ingrese un número positivo: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número: ");
            }
        }
        return input;
    }
}