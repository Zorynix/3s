package z1;
import java.util.Arrays; // метод toString() для вывода массива на экран
import java.util.Random;

public class RandomArraySorting1{
    public static void main(String[] args) {
        int arraySize = 10;

        // Создаем массив с использованием метода random() класса Math
        double[] randomArray1 = new double[arraySize];
        for (int i = 0; i < arraySize; i++) { //заполняем массив
            randomArray1[i] = Math.random();
        }

        // Выводим исходный массив на экран
        System.out.println("Исходный массив (Math.random()):");
        System.out.println(Arrays.toString(randomArray1)); // Преобразуем массив в строку и выводим на экран

        // Сортируем массив
        Arrays.sort(randomArray1);

        // Выводим отсортированный массив на экран
        System.out.println("Отсортированный массив (Math.random()):");
        System.out.println(Arrays.toString(randomArray1));

        // Создаем массив с использованием класса Random
        double[] randomArray2 = new double[arraySize]; // Объявляем и создаем второй массив с типом элементов double и размером arraySize
        Random random = new Random(); // Создаем объект класса Random для генерации случайных чисел
        for (int i = 0; i < arraySize; i++) {
            randomArray2[i] = random.nextDouble();
        }

        // Выводим исходный массив на экран
        System.out.println("Исходный массив (Random.nextDouble()):");
        System.out.println(Arrays.toString(randomArray2));

        // Сортируем второй массив
        Arrays.sort(randomArray2);

        // Выводим отсортированный второй массив на экран
        System.out.println("Отсортированный массив (Random.nextDouble()):");
        System.out.println(Arrays.toString(randomArray2));
    }
}
