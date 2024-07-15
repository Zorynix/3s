package ru.mirea.lab14; // Объявление пакета

import java.util.regex.*; // Импорт классов для работы с регулярными выражениями

public class task2 { // Объявление публичного класса с именем task2

    public static void main(String[] args) { // Основной метод программы
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; // Регулярное выражение для проверки email-адресов
        String[] emails = { // Массив строк с email-адресами для проверки
                "user@example.com",
                "root@localhost",
                "myhost@@@com.ru",
                "@my.ru",
                "Julia String"
        };
        Pattern pattern = Pattern.compile(regex); // Создание объекта Pattern для компиляции регулярного выражения

        for (String email : emails) { // Цикл для перебора всех email-адресов из массива
            Matcher matcher = pattern.matcher(email); // Создание объекта Matcher для сопоставления с регулярным выражением
            if (matcher.matches()) { // Проверка, соответствует ли строка регулярному выражению
                System.out.println(email + " - правильный формат"); // Если соответствует - выводим сообщение о правильном формате
            } else {
                System.out.println(email + " - неправильный формат"); // Если не соответствует - выводим сообщение о неправильном формате
            }
        }
    }
}
