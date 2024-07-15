package z1;

import java.util.Arrays;
import java.util.Random;

public class u3 {
    public static void main(String[] args) {
        // Создаем генератор случайных чисел
        Random random = new Random();

        // Создаем массив из 4 случайных целых чисел
        int[] array = new int[4];
        for (int i = 0; i < 4; i++) {
            array[i] = random.nextInt(90) + 10; // Генерируем число в диапазоне [10;99]
        }

        // Выводим массив на экран
        System.out.println("Массив: " + Arrays.toString(array));

        // Проверяем, является ли массив строго возрастающей последовательностью
        boolean isIncreasing = true;
        for (int i = 1; i < 4; i++) {
            if (array[i] <= array[i - 1]) {
                isIncreasing = false; // Массив не является строго возрастающей последовательностью
                break;
            }
        }

        // Выводим сообщение о результате
        if (isIncreasing) {
            System.out.println("Массив является строго возрастающей последовательностью.");
        } else {
            System.out.println("Массив не является строго возрастающей последовательностью.");
        }
    }
}