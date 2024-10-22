package ru.mirea.lab14; // Объявление пакета

import java.util.regex.*; // Импорт классов для работы с регулярными выражениями

public class task1 { // Объявление публичного класса с именем task1

    public static void main(String[] args) { // Основной метод программы
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19\\d{2}|[2-9]\\d{3})$";
        // Регулярное выражение для проверки дат в формате dd/mm/yyyy, с ограничением с 1900 до 9999 года

        String[] dates = { // Массив строк с датами для проверки
                "29/02/2000",
                "30/04/2003",
                "01/01/2003",
                "29/02/2001",
                "30-04-2003",
                "1/1/1899"
        };
        Pattern pattern = Pattern.compile(regex); // Создание объекта Pattern для компиляции регулярного выражения

        for (String date : dates) { // Цикл для перебора всех дат из массива
            Matcher matcher = pattern.matcher(date); // Создание объекта Matcher для сопоставления с регулярным выражением
            if (matcher.matches()) { // Проверка, соответствует ли строка регулярному выражению
                System.out.println(date + " - правильный формат"); // Если соответствует - выводим сообщение о правильном формате
            } else {
                System.out.println(date + " - неправильный формат"); // Если не соответствует - выводим сообщение о неправильном формате
            }
        }
    }
}
