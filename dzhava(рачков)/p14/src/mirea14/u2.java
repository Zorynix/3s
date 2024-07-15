package mirea14;
//Написать регулярное выражение, определяющее является ли данная
//строка строкой "abcdefghijklmnopqrstuv18340" или нет.
//a) пример правильных выражений: abcdefghijklmnopqrstuv18340
//b) пример неправильных выражений:
//abcdefghijklmnoasdfasdpqrstuv18340.
import java.util.regex.*;

public class u2 {

    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstuv18340";  // Создание строки "abcdefghijklmnopqrstuv18340" и присвоение переменной input

        String pattern = "^abcdefghijklmnopqrstuv18340$";  // Создание регулярного выражения для точного соответствия

        if (Pattern.matches(pattern, input)) {  // Проверка, соответствует ли input заданному регулярному выражению
            System.out.println("Это правильная строка");  // Вывод сообщения, если соответствие найдено
        } else {
            System.out.println("Это неправильная строка");  // Вывод сообщения, если соответствие не найдено
        }
    }
}
