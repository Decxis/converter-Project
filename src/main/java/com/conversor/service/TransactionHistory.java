package com.conversor.service;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private final List<String> history;

    public TransactionHistory() {
        history = new ArrayList<>();
    }

    public void addTransaction(String transaction) {
        history.add(transaction);
    }

    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            System.out.println("\n=== Historial de Transacciones ===");
            for (String transaction : history) {
                System.out.println(transaction);
            }
        }
    }
}
