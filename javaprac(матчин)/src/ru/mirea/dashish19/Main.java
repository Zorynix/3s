package ru.mirea.dashish19;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Проверка ArrayToListConverter

        // Создание массива строк
        String[] stringArray = {"Hello", "World", "Java"};

        // Конвертация массива строк в список
        List<String> stringList = ArrayToListConverter.convertArrayToList(stringArray);

        // Вывод результата
        System.out.println("Результат преобразования массива в список:");
        System.out.println(stringList);

        // Создание массива целых чисел
        Integer[] intArray = {1, 2, 3, 4, 5};

        // Конвертация массива целых чисел в список
        List<Integer> intList = ArrayToListConverter.convertArrayToList(intArray);

        // Вывод результата
        System.out.println(intList);

        // Проверка GenericArray

        // Создание массива целых чисел
        Integer[] integerArray = {10, 20, 30};

        // Создание объекта GenericArray для хранения массива целых чисел
        GenericArray<Integer> genericIntArray = new GenericArray<>(integerArray);

        // Вывод результата
        System.out.println("\nОбобщенный массив:");
        Integer[] resultIntArray = genericIntArray.getArray();
        for (Integer num : resultIntArray) {
            System.out.print(num + " ");
        }

        // Создание массива строк
        String[] strArray = {"Один", "Два", "Три"};

        // Создание объекта GenericArray для хранения массива строк
        GenericArray<String> genericStringArray = new GenericArray<>(strArray);

        // Вывод результата
        System.out.println("\nОбобщенный массив:");
        String[] resultStringArray = genericStringArray.getArray();
        for (String str : resultStringArray) {
            System.out.print(str + " ");
        }

        // Проверка ArrayElementGetter

        // Создание массива целых чисел
        Integer[] intArray2 = {100, 200, 300, 400, 500};

        // Выбор элемента из массива по индексу
        int index = 2;
        try {
            Integer element = ArrayElementGetter.getElement(intArray2, index);

            // Вывод результата
            System.out.println("\n\nРезультат массива элементов:");
            System.out.println("Элемент с индексом " + index + ": " + element);
        } catch (IndexOutOfBoundsException e) {
            // Вывод ошибки, если индекс выходит за пределы массива
            System.out.println(e.getMessage());
        }
    }
}
