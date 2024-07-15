package mirea14;
//Написать регулярное выражение, определяющее является ли данная
//строчка датой в формате dd/mm/yyyy. Начиная с 1900 года до 9999 года.
//a) пример правильных выражений: 29/02/2000, 30/04/2003,
//01/01/2003.
//b) пример неправильных выражений: 30-04-2003, 1/1/1899.
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class u5 {
    public static void main(String[] args) {
        String date = "29/02/2000";

        String regex = "^(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/(19\\d{2}|[2-9]\\d{3})$";

        Pattern pattern = Pattern.compile(regex);

        // Создаем Matcher для выполнения проверки
        Matcher matcher = pattern.matcher(date);

        // Проверяем, соответствует ли строка дате в заданном формате и диапазоне
        if (matcher.matches()) {
            System.out.println("Дата является корректной.");
        } else {
            System.out.println("Дата не соответствует формату или диапазону.");
        }
    }
}