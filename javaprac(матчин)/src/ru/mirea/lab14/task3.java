package ru.mirea.lab14;

import java.util.regex.*; // Импорт классов для работы с регулярными выражениями

public class task3 { // Объявление публичного класса с именем PasswordChecker

    public static void main(String[] args) { // Основной метод программы
        // Регулярное выражение для проверки надежности пароля
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d_]{8,}$";

        String[] passwords = { // Массив паролей для проверки
                "F032_Password",
                "TrySpy1",
                "smart_pass",
                "A007"
        };

        Pattern pattern = Pattern.compile(regex); // Создание объекта Pattern для компиляции регулярного выражения

        for (String password : passwords) { // Цикл для перебора всех паролей из массива
            Matcher matcher = pattern.matcher(password); // Создание объекта Matcher для сопоставления с регулярным выражением
            if (matcher.matches()) { // Проверка, соответствует ли пароль регулярному выражению
                System.out.println(password + " - надежный пароль"); // Если соответствует - выводим сообщение о надежности пароля
            } else {
                System.out.println(password + " - ненадежный пароль"); // Если не соответствует - выводим сообщение о ненадежности пароля
            }
        }
    }
}
