package z1;

import java.util.Random;
import java.util.Scanner;

public class u4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            // Запрашиваем у пользователя размер массива
            System.out.print("Введите размер массива (натуральное число больше 0): ");
            while (!scanner.hasNextInt()) { // Проверяем, введено ли целое число
                System.out.println("Некорректный ввод. Пожалуйста, введите натуральное число больше 0.");
                System.out.print("Введите размер массива: ");
                scanner.next();
            }
            n = scanner.nextInt(); // Считываем введенное пользователем число
        } while (n <= 0); // Повторяем ввод, пока не будет введено натуральное число больше 0

        // Создаем массив из n случайных целых чисел из отрезка [0; n]
        int[] array = new int[n];
        Random random = new Random(); // Создаем генератор случайных чисел
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n + 1);
        }

        // Выводим первый массив на экран
        System.out.print("Первый массив: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " "); // Выводим элементы массива через пробел
        }
        System.out.println();

        // Создаем второй массив только из четных элементов первого массива, если они там есть
        int[] evenArray = new int[n]; // Создаем второй массив
        int evenCount = 0; // Счетчик четных элементов
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0) { // Проверяем, является ли элемент четным
                evenArray[evenCount] = array[i]; // Добавляем четный элемент во второй массив
                evenCount++; // Увеличиваем счетчик четных элементов
            }
        }

        // Выводим второй массив на экран
        System.out.print("Второй массив (четные элементы первого): ");
        for (int i = 0; i < evenCount; i++) {
            System.out.print(evenArray[i] + " "); // Выводим элементы второго массива
        }
        System.out.println();

        scanner.close();
    }
}
