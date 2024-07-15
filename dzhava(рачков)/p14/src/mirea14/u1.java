package mirea14;
//Необходимо реализовать консольное приложение, позволяющее
//манипулировать строкой, разбив ее на элементы путем использования
//регулярных выражений.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class u1 {
    public static void main(String[] args) {
        String input = "Пример строки для разбивки на элементы";

        String regex = "\\s+"; //разделение по пробелам //регулярное выражение

        // объект Pattern для регулярного выражения
        Pattern pattern = Pattern.compile(regex);

        // Matcher для разбиения строки(использование регулярки через патерн)
        Matcher matcher = pattern.matcher(input);

        // Находим и выводим элементы
        int start = 0;
        while (matcher.find()) {
            String element = input.substring(start, matcher.start());
            start = matcher.end();
            System.out.println(element);
        }

        // Выводим последний элемент
        if (start < input.length()) {
            String element = input.substring(start);
            System.out.println(element);
        }
    }
}