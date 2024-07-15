package mirea14;
//Дан текст, необходимо проверить есть ли в тексте цифры, за
//которыми не стоит знак «+».
//a) пример правильных выражений:(1 + 8) – 9 / 4
//b) пример неправильных выражений: 6 / 5 – 2 * 9
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class u4 {
    public static void main(String[] args) {
        String text = "(1+8)-9/4";

        // регулярное выражение для поиска цифр без знака "+"
        Pattern pattern = Pattern.compile("\\d(?!\\+)");

        // Создаем объект Matcher для выполнения поиска в тексте
        Matcher matcher = pattern.matcher(text);

        // Переменная для отслеживания наличия цифр без "+"
        boolean found = false;

        // Поиск и проверка наличия цифр
        while (matcher.find()) {
            found = true;
            break;
        }


        if (found) {
            System.out.println("В тексте есть цифры без знака \"+\".");
        } else {
            System.out.println("В тексте нет цифр без знака \"+\".");
        }
    }
}
