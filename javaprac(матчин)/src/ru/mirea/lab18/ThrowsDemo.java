package ru.mirea.lab18;

import java.util.Scanner;

public class ThrowsDemo {
    // Метод getKey может выбросить исключение типа Exception
    public void getKey() throws Exception {
        Scanner myScanner = new Scanner(System.in);
        int attempts = 2;

        while (attempts > 0) {
            String key = myScanner.next();
            try {
                printDetails(key);
                return; // Если успешно, выходим из цикла
            } catch (Exception e) {
                System.out.println("Поймано исключение: " + e.getMessage());
                attempts--;
                if (attempts == 0) {
                    System.out.println("Исчерпаны попытки. Завершение работы.");
                } else {
                    System.out.println("У вас осталось " + attempts + " попыток. Пожалуйста, введите корректный ключ:");
                }
            }
        }
    }

    // Метод printDetails может выбросить исключение типа Exception
    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    // Метод getDetails может выбросить исключение типа Exception
    private String getDetails(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Ключ установлен как пустая строка");
        }
        return "данные для " + key;
    }

    // Метод manuallyTriggerException вызывает исключение типа Exception вручную
    public void manuallyTriggerException() {
        try {
            throw new Exception("Исключение вызвано вручную");
        } catch (Exception e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }
    }
}
