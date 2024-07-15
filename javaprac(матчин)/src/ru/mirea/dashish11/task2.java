package ru.mirea.dashish11;

import java.util.Comparator;

class Student2 {
    private String name;
    private double GPA;

    public Student2(String name, double GPA) {
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

public class task2 implements Comparator<Student2> {

    // Метод для сравнения двух студентов по их итоговому баллу (GPA)
    @Override
    public int compare(Student2 student1, Student2 student2) {
        // Сортировка в порядке убывания GPA
        return Double.compare(student2.getGPA(), student1.getGPA());
    }

    // Метод для быстрой сортировки массива студентов по их GPA
    public void quickSortStudentsByGPA(Student2[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSortStudentsByGPA(arr, low, pi - 1);
            quickSortStudentsByGPA(arr, pi + 1, high);
        }
    }

    // Вспомогательный метод для быстрой сортировки - partition
    private int partition(Student2[] arr, int low, int high) {
        double pivot = arr[high].getGPA();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (compare(arr[j], arr[high]) > 0) {
                i++;

                Student2 temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Student2 temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Student2[] students = {
                new Student2("Alice", 3.8),
                new Student2("Bob", 3.5),
                new Student2("Charlie", 4.0),
                new Student2("David", 3.9)
        };

        task2 sorter = new task2();
        sorter.quickSortStudentsByGPA(students, 0, students.length - 1);

        // Вывод отсортированного массива
        System.out.println("Студенты после сортировки по GPA в порядке убывания:");
        for (Student2 student : students) {
            System.out.println(student.getName() + " - GPA: " + student.getGPA());
        }
    }
}
