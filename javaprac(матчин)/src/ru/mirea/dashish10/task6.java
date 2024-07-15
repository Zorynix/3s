package ru.mirea.dashish10;

public class task6 {

    // Рекурсивная функция для проверки числа на простоту
    public static boolean isPrime(int n, int divisor) {
        // Базовый случай: если делитель стал больше корня из n, число простое
        if (divisor > Math.sqrt(n)) {
            return true;
        }
        // Если число делится на divisor без остатка, оно составное
        if (n % divisor == 0) {
            return false;
        }
        // Рекурсивный случай: проверяем следующий делитель
        return isPrime(n, divisor + 1);
    }

    public static void main(String[] args) {
        int number = 17; // Ваше число для проверки
        if (number <= 1) {
            System.out.println("NO");
        } else {
            boolean isPrime = isPrime(number, 2);
            if (isPrime) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
