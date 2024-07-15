package mirea14;
//Дан текст со списками цен. Извлечь из него цены в USD, RUВ, EUR.
//a) пример правильных выражений: 25.98 USD.
//b) пример неправильных выражений: 44 ERR, 0.004 EU.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class u3 {
    public static void main(String[] args) {
        String text = "Список цен: 25.98 USD, 1500 RUB, 12.45 EUR, 44 ERR, 12.77 EUR, 0.004 EU.";

        // регулярные выражения для поиска цен в формате USD, RUB и EUR
        Pattern usdPattern = Pattern.compile("(\\d+\\.\\d{2}) USD");
        Pattern rubPattern = Pattern.compile("(\\d+) RUB");
        Pattern eurPattern = Pattern.compile("(\\d+\\.\\d{2}) EUR");

        // Создаем объекты Matcher для выполнения поиска в тексте
        Matcher usdMatcher = usdPattern.matcher(text);
        Matcher rubMatcher = rubPattern.matcher(text);
        Matcher eurMatcher = eurPattern.matcher(text);

        // Используем циклы для извлечения и печати найденных цен
        while (usdMatcher.find()) {
            System.out.println(usdMatcher.group(1) + " USD");
        }

        while (rubMatcher.find()) {
            System.out.println(rubMatcher.group(1) + " RUB");
        }

        while (eurMatcher.find()) {
            System.out.println(eurMatcher.group(1) + " EUR");
        }
    }
}
