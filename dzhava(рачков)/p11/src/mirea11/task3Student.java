package mirea11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class task3Student {
    private String name;
    private Date dateOfBirth;


    public task3Student(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); // Создание форматтера даты.
        String formattedDate = dateFormat.format(dateOfBirth); // Форматирование даты рождения.

        return "Имя: " + name + "\nДата рождения: " + formattedDate;
        // Возвращаем строку с именем и отформатированной датой рождения.
    }
}