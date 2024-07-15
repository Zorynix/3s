package ru.mirea.lab7;

// Интерфейс StringOperations
interface StringOperations {
    int countCharacters(String s);  // Метод для подсчета символов в строке
    String oddPositionChars(String s);  // Метод для получения символов на нечетных позициях
    String reverseString(String s);  // Метод для инвертирования строки
}

// Класс, реализующий интерфейс StringOperations
class StringProcessor implements StringOperations {

    @Override
    public int countCharacters(String s) {
        return s.length();  // Возвращает длину строки, то есть количество символов
    }

    @Override
    public String oddPositionChars(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));  // Добавляет символы на нечетных позициях в результирующую строку
        }

        return result.toString();  // Возвращает результат в виде строки
    }

    @Override
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();  // Инвертирует строку и возвращает результат
    }
}

public class Main {
    public static void main(String[] args) {
        StringOperations operations = new StringProcessor();  // Создаем объект класса StringProcessor, реализующего интерфейс StringOperations

        String s = "Hello, World!";

        // Подсчет символов
        int charCount = operations.countCharacters(s);
        System.out.println("Количество символов: " + charCount);

        // Строка из символов на нечетных позициях
        String oddChars = operations.oddPositionChars(s);
        System.out.println("Символы на нечетных позициях: " + oddChars);

        // Инвертированная строка
        String reversed = operations.reverseString(s);
        System.out.println("Инвертированная строка: " + reversed);
    }
}
