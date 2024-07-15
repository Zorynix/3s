package ru.mirea.lab3;

import java.util.Arrays;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        // Создаем массив из 4 случайных целых чисел
        int[] arr = new int[4];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            arr[i] = random.nextInt(90) + 10; // Генерация чисел от 10 до 99
        }

        // Выводим массив на экран
        System.out.println("Массив:");
        System.out.println(Arrays.toString(arr));

        // Проверяем, является ли массив строго возрастающей последовательностью
        boolean isIncreasing = true;
        for (int i = 1; i < 4; i++) {
            if (arr[i] <= arr[i - 1]) {
                isIncreasing = false;
                break;
            }
        }

        // Выводим результат на экран
        if (isIncreasing) {
            System.out.println("Массив является строго возрастающей последовательностью.");
        } else {
            System.out.println("Массив не является строго возрастающей последовательностью.");
        }
    }
}
