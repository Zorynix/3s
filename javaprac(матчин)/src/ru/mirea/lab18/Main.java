package ru.mirea.lab18;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        try {
            //demo.getKey(); // Можно использовать этот метод, как ранее
            demo.manuallyTriggerException(); // Вызываем исключение вручную
        } catch (Exception e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }
    }
}
