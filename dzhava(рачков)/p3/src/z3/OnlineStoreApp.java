package z3;

import java.util.Scanner;

public class OnlineStoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Имитация списка товаров с ценами в разных валютах (например, USD и EUR)
        String[] products = {"Product A", "Product B", "Product C"};
        double[] pricesUSD = {10.0, 20.0, 30.0};
        double[] pricesEUR = {8.5, 17.0, 25.5};

        // Вывод списка товаров
        System.out.println("Available Products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }

        System.out.print("Select a product (1-" + products.length + "): ");
        int selectedProductIndex = scanner.nextInt() - 1; // Чтение выбора товара от пользователя и коррекция на 1 для индексации

        // Проверка на корректный выбор товара
        if (selectedProductIndex < 0 || selectedProductIndex >= products.length) {
            System.out.println("Invalid product selection.");
            return;
        }

        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt(); // Чтение количества товара от пользователя

        System.out.println("Select currency for payment:");
        System.out.println("1. USD");
        System.out.println("2. EUR");

        System.out.print("Enter currency choice (1 or 2): ");
        int currencyChoice = scanner.nextInt(); // Чтение выбора валюты от пользователя

        double totalPrice;
        String currencySymbol;

        // Рассчет общей стоимости и выбор символа валюты в зависимости от выбора пользователя
        if (currencyChoice == 1) {
            totalPrice = pricesUSD[selectedProductIndex] * quantity;
            currencySymbol = "USD";
        } else if (currencyChoice == 2) {
            totalPrice = pricesEUR[selectedProductIndex] * quantity;
            currencySymbol = "EUR";
        } else {
            System.out.println("Invalid currency choice.");
            return;
        }

        // Вывод общей стоимости в выбранной валюте
        System.out.printf("Total cost in %s: %.2f %s%n", currencySymbol, totalPrice, currencySymbol);

        // Закрытие сканнера
        scanner.close();
    }
}
