package ru.mirea.dashish10;

public class task5 {

    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n % 10 + sumOfDigits(n / 10);
        }
    }

    public static void main(String[] args) {
        int number = 12345;
        int sum = sumOfDigits(number);
        System.out.println("Сумма цифр числа " + number + " равна " + sum);
    }
}
