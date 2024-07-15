package mirea14;
//Напишите метод filter, который принимает на вход массив (любого
//типа) и реализацию интерфейса Filter c методом apply(Object o), чтобы убрать
//из массива лишнее. Проверьте как он работает на строках или других объектах.
import java.util.ArrayList;
import java.util.List;

// Интерфейс Filter с методом apply
interface Filter {
    boolean apply(Object o);
}

public class u8 {
    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "cherry", "date", "elderberry"};

        // Создаем объект фильтра для строк, который оставляет только строки, начинающиеся с буквы "a"
        Filter stringFilter = new Filter() {
            @Override
            public boolean apply(Object o) {
                if (o instanceof String) {
                    String s = (String) o;
                    return s.startsWith("a");
                }
                return false; // Если объект не является строкой
            }
        };

        // Фильтруем массив строк
        String[] filteredStrings = (String[]) filter(strings, stringFilter);

        // Выводим результат
        for (String s : filteredStrings) {
            System.out.println(s);
        }
    }

    // Метод filter для фильтрации массива
    public static Object[] filter(Object[] array, Filter filter) {
        List<Object> resultList = new ArrayList<>();
        for (Object item : array) {
            if (filter.apply(item)) {
                resultList.add(item);
            }
        }
        return resultList.toArray();
    }
}