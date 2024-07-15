package ru.mirea.dashish10;

public class task4 {

    // Функция для подсчёта количества k-значных чисел с суммой цифр s
    public static int countNumbers(int k, int s) {
        // Если k равно 0 (не осталось цифр для использования) и s равно 0, возвращаем 1
        if (k == 0 && s == 0) {
            return 1;
        }
        // Если k стало меньше 0 или s стало отрицательным, возвращаем 0
        if (k < 0 || s < 0) {
            return 0;
        }

        int count = 0;

        // Цикл для перебора всех возможных цифр от 1 до 9
        for (int i = 1; i <= 9; i++) {
            // Рекурсивно вызываем функцию для уменьшения k на 1 и s на значение i
            count += countNumbers(k - 1, s - i);
        }

        return count;
    }

    public static void main(String[] args) {
        int k = 3; // Количество цифр в числе
        int s = 15; // Сумма цифр

        int result = countNumbers(k, s);
        System.out.println("Количество " + k + "-значных чисел с суммой цифр " + s + ": " + result);
    }
}
