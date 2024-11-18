package com.conversor;



import com.conversor.service.CurrencyConverterService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverterService converterService = new CurrencyConverterService();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Menú de Conversor de Divisas ===");
            System.out.println("1. Convertir divisas");
            System.out.println("2. Ver tasa de cambio");
            System.out.println("3. Ver historial de transacciones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (choice) {
                case 1:
                    
                    converterService.convertCurrencyMenu(scanner);
                    break;
                case 2:
                    converterService.viewExchangeRate(scanner);
                    break;
                case 3:
                    converterService.viewTransactionHistory();
                    break;
                case 4:
                    running = false;
                    System.out.println("Gracias por usar el conversor de divisas.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }

        scanner.close();
    }
}
