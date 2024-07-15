package ru.mirea.lab13; // Объявление пакета

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите абсолютный путь к файлу: ");
        String fileName = reader.readLine(); // Чтение абсолютного пути к файлу из консоли
        reader.close(); // Закрытие потока чтения

        ArrayList<String> wordsList = readWordsFromFile(fileName); // Чтение слов из файла и сохранение в ArrayList
        String result = getLine(wordsList.toArray(new String[0])); // Формирование результата перестановки слов
        System.out.println(result); // Вывод результата на экран
    }

    public static ArrayList<String> readWordsFromFile(String fileName) throws Exception {
        ArrayList<String> wordsList = new ArrayList<>(); // Создание ArrayList для хранения слов
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName)); // Открытие файла для чтения
        String line;
        while ((line = fileReader.readLine()) != null) { // Построчное чтение файла
            String[] words = line.split(" "); // Разделение строки на слова
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordsList.add(word); // Добавление непустых слов в ArrayList
                }
            }
        }
        fileReader.close(); // Закрытие потока чтения
        return wordsList; // Возврат списка слов
    }

    public static String getLine(String... words) {
        if (words == null || words.length == 0) {
            return ""; // Возвращаем пустую строку, если не переданы слова
        }

        StringBuilder result = new StringBuilder(words[0]); // Инициализация результирующей строки первым словом
        ArrayList<String> remainingWords = new ArrayList<>(); // Создание списка оставшихся слов

        for (int i = 1; i < words.length; i++) {
            remainingWords.add(words[i]); // Добавление оставшихся слов в список
        }

        while (true) {
            if (remainingWords.isEmpty()) {
                break; // Выход из цикла, если список оставшихся слов пуст
            }

            char lastChar = Character.toLowerCase(result.charAt(result.length() - 1)); // Получение последней буквы результирующей строки
            boolean found = false;

            for (int i = 0; i < remainingWords.size(); i++) {
                String word = remainingWords.get(i); // Получение текущего слова из списка оставшихся
                char firstChar = Character.toLowerCase(word.charAt(0)); // Получение первой буквы текущего слова

                if (lastChar == firstChar) { // Проверка совпадения последней буквы результирующей строки и первой буквы текущего слова
                    result.append(" ").append(word); // Добавление слова к результирующей строке
                    remainingWords.remove(i); // Удаление слова из списка оставшихся
                    found = true;
                    break;
                }
            }

            if (!found) {
                break; // Выход из цикла, если не найдено подходящее слово
            }
        }

        return result.toString(); // Возвращаем результирующую строку
    }
}

//C:\Users\Jeka\Desktop\3sem\ЖАБА\praca1\src\ru\mirea\lab13\input.txt