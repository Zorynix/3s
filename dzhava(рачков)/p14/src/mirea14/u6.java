package mirea14;
//Написать регулярное выражение, определяющее является ли данная
//строчка допустимым (корректным) е-mail адресом согласно RFC под номером
//2822.
//a) пример правильных выражений: user@example.com
//b) пример неправильных выражений: myhost@@@com.ru, @my.ru,
//Julia String.
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class u6 {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static void main(String[] args) {
        // Примеры email адресов
        String[] validEmails = {
                "user@example.com",
                "root@local.host"
        };

        String[] invalidEmails = {
                "myhost@@@com.ru",
                "@my.ru",
                "Julia String"
        };

        // Проверка правильных email адресов
        System.out.println("Правильные email адреса:");
        for (String email : validEmails) {
            boolean isValid = validateEmail(email);
            System.out.println(email + " - " + (isValid ? "Допустимый" : "Недопустимый"));
        }

        // Проверка неправильных email адресов
        System.out.println("\nНеправильные email адреса:");
        for (String email : invalidEmails) {
            boolean isValid = validateEmail(email);
            System.out.println(email + " - " + (isValid ? "Допустимый" : "Недопустимый"));
        }
    }

    private static boolean validateEmail(String email) {
        // Создаем Pattern с использованием регулярного выражения для email
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        // Создаем Matcher для проверки email
        Matcher matcher = pattern.matcher(email);
        // Возвращаем результат проверки
        return matcher.matches();
    }
}
