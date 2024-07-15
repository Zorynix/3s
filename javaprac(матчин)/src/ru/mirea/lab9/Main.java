package ru.mirea.lab9;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

// Класс, представляющий студента с итоговым баллом
class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}

// Класс, реализующий Comparator для сортировки по итоговым баллам
class SortingStudentsByGPA implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getGpa() > student2.getGpa()) {
            return -1; // Сортировка по убыванию
        } else if (student1.getGpa() < student2.getGpa()) {
            return 1;
        } else {
            return 0;
        }
    }
}



public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("John Doe", 3.5),
                new Student("Jane Doe", 4.0),
                new Student("Bob Smith", 3.8)
        );

        // Сортировка с использованием SortingStudentsByGPA
        students.sort(new SortingStudentsByGPA());

        // Вывод отсортированного списка
        for (Student student : students) {
            System.out.println(student.getName() + ": " + student.getGpa());
        }
    }
}

