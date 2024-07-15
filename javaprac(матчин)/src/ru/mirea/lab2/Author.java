package ru.mirea.lab2;

// Создаем класс Author для представления информации об авторе
public class Author {
    private String name;    // Имя автора
    private String email;   // Email автора
    private char gender;    // Пол автора ('M' - мужской, 'F' - женский, например)

    // Конструктор класса Author для инициализации полей
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Метод для получения имени автора
    public String getName() {
        return name;
    }

    // Метод для получения email автора
    public String getEmail() {
        return email;
    }

    // Метод для установки нового email автора
    public void setEmail(String email) {
        this.email = email;
    }

    // Метод для получения пола автора
    public char getGender() {
        return gender;
    }


    //Метод в подклассе является переопределением (override) метода с такой же сигнатурой
    //(именем, типами аргументов и возвращаемым значением)
    @Override

    // Метод для представления информации об авторе в виде строки
    public String toString() {
        return "Author [name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}