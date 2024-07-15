package ru.mirea.lab2;

import java.util.ArrayList;
import java.util.List;

public class DogKennel {
    private List<Dog> dogs; // Список собак в питомнике

    // Конструктор класса DogKennel для инициализации списка собак
    public DogKennel() {
        dogs = new ArrayList<>();
    }


    // Метод для добавления собаки в питомник
    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public static void main(String[] args) {
        DogKennel kennel = new DogKennel();

        // Создание нескольких собак и добавление их в питомник
        Dog dog1 = new Dog("Buddy", 3);
        Dog dog2 = new Dog("Max", 5);
        Dog dog3 = new Dog("Charlie", 2);

        kennel.addDog(dog1);
        kennel.addDog(dog2);
        kennel.addDog(dog3);

        // Вывод информации о собаках в питомнике
        List<Dog> kennelDogs = kennel.getDogs();
        for (Dog dog : kennelDogs) {
            System.out.println("Dog Name: " + dog.getName());
            System.out.println("Dog Age: " + dog.getAge() + " years");
            System.out.println("Human Age: " + dog.calculateHumanAge() + " years");
            System.out.println(dog.toString());
        }
    }
}
