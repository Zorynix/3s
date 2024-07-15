package ru.mirea.dashish10;

public class task7 {

    // Рекурсивная функция для нахождения простых множителей
    public static void primeFactors(int n, int divisor) {
        // Пока число делится на divisor без остатка, выводим divisor и делим n на него
        while (n % divisor == 0) {
            System.out.print(divisor + " ");
            n /= divisor;
        }

        // Если n стало равно 1, выходим из рекурсии
        if (n == 1) {
            return;
        }

        // Ищем следующий простой делитель числа n
        for (int nextDivisor = divisor + 1; nextDivisor <= Math.sqrt(n); nextDivisor++) {
            if (n % nextDivisor == 0) {
                primeFactors(n, nextDivisor);
                return;
            }
        }

        // Если ничего не делится, n само по себе является простым числом
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int number = 200; // Ваше число для разложения на множители
        if (number <= 1) {
            System.out.println("Число должно быть больше 1");
        } else {
            primeFactors(number, 2);
        }
    }
}
