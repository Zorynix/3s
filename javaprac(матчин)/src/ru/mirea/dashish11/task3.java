package ru.mirea.dashish11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student3 {
    private String name;
    private double GPA;

    public Student3(String name, double GPA) {
        this.name = name;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }
}

public class task3 {
    public static void main(String[] args) {
        List<Student3> list1 = new ArrayList<>();
        list1.add(new Student3("Alice", 3.8));
        list1.add(new Student3("Bob", 3.5));
        list1.add(new Student3("Charlie", 4.0));

        List<Student3> list2 = new ArrayList<>();
        list2.add(new Student3("David", 3.9));
        list2.add(new Student3("Eva", 3.7));
        list2.add(new Student3("Frank", 3.6));

        // Объединение списков
        List<Student3> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);

        // Сортировка объединенного списка по убыванию GPA
        Collections.sort(mergedList, Comparator.comparing(Student3::getGPA).reversed());

        // Вывод отсортированного списка
        System.out.println("Объединенный и отсортированный список студентов по убыванию GPA:");
        for (Student3 student : mergedList) {
            System.out.println(student.getName() + " - GPA: " + student.getGPA());
        }
    }
}


