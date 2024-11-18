package com.conversor.service;

import com.conversor.util.HttpUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Scanner;

public class CurrencyConverterService {
    private static final String API_KEY = "f49ce3e10591281eda876ee4"; // Reemplaza con tu clave de la API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    private static final Currency[] CURRENCIES = {
            new Currency("United States Dollar", "USD"),
            new Currency("Euro", "EUR"),
            new Currency("British Pound Sterling", "GBP"),
            new Currency("Japanese Yen", "JPY"),
            new Currency("Australian Dollar", "AUD"),
            new Currency("Canadian Dollar", "CAD"),
            new Currency("Swiss Franc", "CHF"),
            new Currency("Chinese Yuan", "CNY"),
            new Currency("Swedish Krona", "SEK"),
            new Currency("New Zealand Dollar", "NZD")
    };

    private final TransactionHistory transactionHistory;

    public CurrencyConverterService() {
        this.transactionHistory = new TransactionHistory();
    }

    public void convertCurrencyMenu(Scanner scanner) {
        String fromCurrency = selectCurrency(scanner).getCode();
        String toCurrency = selectCurrency(scanner).getCode();

        System.out.print("Ingrese la cantidad a convertir: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        try {
            // Obtener la tasa de cambio
            double rate = getExchangeRate(fromCurrency, toCurrency);
            if (rate != -1) {
                double convertedAmount = convertCurrency(amount, rate);
                System.out.printf("La cantidad convertida de %s a %s es: %.2f%n", fromCurrency, toCurrency, convertedAmount);

                // Agregar transacción al historial
                String transaction = String.format("Convertido %.2f %s a %.2f %s con una tasa de %.4f", amount, fromCurrency, convertedAmount, toCurrency, rate);
                transactionHistory.addTransaction(transaction);
            } else {
                System.out.println("No se pudo obtener la tasa de cambio para las monedas especificadas.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar convertir la moneda.");
            e.printStackTrace();
        }
    }

    public void viewExchangeRate(Scanner scanner) {
        String fromCurrency = selectCurrency(scanner).getCode();
        String toCurrency = selectCurrency(scanner).getCode();

        try {
            // Obtener la tasa de cambio
            double rate = getExchangeRate(fromCurrency, toCurrency);
            if (rate != -1) {
                System.out.printf("La tasa de cambio de %s a %s es: %.4f%n", fromCurrency, toCurrency, rate);
            } else {
                System.out.println("No se pudo obtener la tasa de cambio para las monedas especificadas.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar obtener la tasa de cambio.");
            e.printStackTrace();
        }
    }

    private double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        String response = HttpUtil.get(API_URL + fromCurrency);
        JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

        if (conversionRates.has(toCurrency)) {
            return conversionRates.get(toCurrency).getAsDouble();
        } else {
            return -1; // Retornar -1 si no se encuentra la tasa de cambio
        }
    }

    private Currency selectCurrency(Scanner scanner) {
        System.out.println("Seleccione una moneda:");
        for (int i = 0; i < CURRENCIES.length; i++) {
            System.out.printf("%d. %s%n", i + 1, CURRENCIES[i]);
        }
        System.out.print("Ingrese el número correspondiente a la moneda: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (choice >= 1 && choice <= CURRENCIES.length) {
            return CURRENCIES[choice - 1];
        } else {
            System.out.println("Opción no válida. Se seleccionará USD por defecto.");
            return new Currency("United States Dollar", "USD"); // Valor por defecto
        }
    }

    private double convertCurrency(double amount, double rate) {
        return amount * rate;
    }
    public void viewTransactionHistory() {
        if (transactionHistory != null) {
            transactionHistory.printHistory();
        } else {
            System.out.println("No hay historial disponible.");
        }
    }

}
