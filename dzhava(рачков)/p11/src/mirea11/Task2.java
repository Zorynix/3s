package mirea11;

import java.text.ParseException;  // для обработки исключений
import java.text.SimpleDateFormat;  // для работы с форматом даты
import java.util.Date;  // для работы с датой и временем
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Создаем объект SimpleDateFormat с указанным форматом даты и времени.


        System.out.print("Введите дату (гггг-мм-дд ЧЧ:мм:сс): ");

        String inputDateStr = scanner.nextLine();

        Date inputDate = dateFormat.parse(inputDateStr);
        // Парсим введенную строку и преобразуем ее в объект Date с использованием указанного формата.

        Date currentDate = new Date();  // Создаем объект Date для текущей даты и времени.

        if (inputDate.before(currentDate)) {  // Сравниваем введенную дату с текущей.
            System.out.println("Введенная дата меньше текущей даты.");
        } else if (inputDate.after(currentDate)) {
            System.out.println("Введенная дата больше текущей даты.");
        } else {
            System.out.println("Введенная дата равна текущей дате.");
        }
    }
}
