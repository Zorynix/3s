package mirea21;
//Написать метод для конвертации массива строк/чисел в список.
import java.util.ArrayList;
import java.util.List;

public class u1 {
    public static List<Object> convertArrayToList(Object[] array) {
        List<Object> list = new ArrayList<>();

        for (Object element : array) {
            list.add(element);
        }

        return list;
    }

    public static void main(String[] args) {
        String[] stringArray = {"apple", "banana", "cherry"};
        Integer[] intArray = {1, 2, 3, 4, 5};

        List<Object> stringList = convertArrayToList(stringArray);
        List<Object> intList = convertArrayToList(intArray);

        System.out.println("String List: " + stringList);
        System.out.println("Integer List: " + intList);
    }
}
