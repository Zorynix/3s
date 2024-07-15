package ru.mirea.lab2;

import java.util.ArrayList;
import java.util.List;
public class Dog {
    private String name;
    private int age;


    // Конструктор класса Dog для инициализации полей
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттер для получения имени собаки
    public String getName() {
        return name;
    }

    // Сеттер для установки имени собаки
    public void setName(String name) {
        this.name = name;
    }


    // Геттер для получения возраста собаки
    public int getAge() {
        return age;
    }


    // Сеттер для установки возраста собаки
    public void setAge(int age) {
        this.age = age;
    }


    // Метод для вычисления "человеческого" возраста собаки
    public int calculateHumanAge() {
        return age * 7;
    }

    // Переопределение метода toString для возврата описания собаки в виде строки
    @Override
    public String toString() {
        return "Dog [name=" + name + ", age=" + age + "]";
    }
}
