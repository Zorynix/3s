package ru.mirea.dashish11;

class Student {
    private int iDNumber;
    private String name;

    public Student(int iDNumber, String name) {
        this.iDNumber = iDNumber;
        this.name = name;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public String getName() {
        return name;
    }
}

public class task1 {

    // Метод сортировки вставками для массива объектов Student по их iDNumber
    public static void insertionSortStudents(Student[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Student key = arr[i];
            int j = i - 1;

            // Перемещаем элементы arr[0..i-1], которые больше key.iDNumber, на одну позицию вперед
            while (j >= 0 && arr[j].getIDNumber() > key.getIDNumber()) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Создание массива объектов Student
        Student[] students = {
                new Student(102, "Alice"),
                new Student(104, "Bob"),
                new Student(101, "Charlie"),
                new Student(103, "David")
        };

        // Вывод массива до сортировки
        System.out.println("Массив до сортировки:");
        for (Student student : students) {
            System.out.println(student.getIDNumber() + " - " + student.getName());
        }

        // Сортировка массива объектов Student по iDNumber сортировкой вставками
        insertionSortStudents(students);

        // Вывод отсортированного массива
        System.out.println("\nМассив после сортировки:");
        for (Student student : students) {
            System.out.println(student.getIDNumber() + " - " + student.getName());
        }
    }
}
