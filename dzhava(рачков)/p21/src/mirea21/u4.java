package mirea21;
//Написать функцию, которая сохранит содержимое каталога в
//список и выведет первые 5 элементов на экран.
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class u4 {
    public static void main(String[] args) {
        String directoryPath = "/путь/к/каталогу";

        List<String> fileList = new ArrayList<>();  // список для хранения имен файлов и каталогов

        File directory = new File(directoryPath);  // объект File, представляющий указанный каталог
        File[] files = directory.listFiles();      // Получаем массив файлов и каталогов в данной директории

        if (files != null) {  // каталог существует и не пуст
            for (File file : files) {  // Проходим по всем файлам и каталогам в массиве
                fileList.add(file.getName());  // Добавляем имена файлов и каталогов в список fileList
            }

            System.out.println("Первые 5 элементов каталога:");

            // Выводим первые 5 элементов списка на экран
            for (int i = 0; i < Math.min(5, fileList.size()); i++) {
                System.out.println(fileList.get(i));
            }
        } else {
            System.out.println("Указанная директория пуста или не существует.");
        }
    }
}
