package ru.mirea.lab14;

interface Filter {
    boolean apply(Object o); // Интерфейс с методом apply, который определяет условие фильтрации.
}

public class task4 {
    public static Object[] filter(Object[] array, Filter filter) {
        int newSize = 0;

        // Подсчет количества элементов, которые проходят фильтрацию.
        for (Object element : array) {
            if (filter.apply(element)) {
                newSize++;
            }
        }

        Object[] result = new Object[newSize]; // Создание нового массива для хранения отфильтрованных элементов.
        int index = 0;

        // Заполнение нового массива отфильтрованными элементами.
        for (Object element : array) {
            if (filter.apply(element)) {
                result[index] = element;
                index++;
            }
        }

        return result; // Возвращение нового массива с отфильтрованными элементами.
    }

    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "cherry", "date"};

        // Создание объекта фильтра для фильтрации строк длиной более 5 символов.
        Filter stringLengthFilter = new Filter() {
            @Override
            public boolean apply(Object o) {
                return ((String) o).length() > 5;
            }
        };

        Object[] filteredStrings = filter(strings, stringLengthFilter); // Применение фильтра к массиву строк.

        System.out.println("Filtered Strings:");
        for (Object str : filteredStrings) {
            System.out.println(str); // Вывод отфильтрованных строк.
        }
    }
}
