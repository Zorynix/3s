package ru.mirea.lab10;

import java.util.Comparator;

public class SortingStudentsByGPA {
    private Student[] iDNumber;

    // Конструктор, принимающий размер массива
    public SortingStudentsByGPA(int size) {
        iDNumber = new Student[size];
    }

    // Метод для заполнения массива
    public void setArray(Student[] students) {
        this.iDNumber = students;
    }

    // Метод для сортировки по среднему баллу с использованием быстрой сортировки
    public void quicksort(Comparator<Student> comparator, int low, int high) {
        if (low < high) {
            int pi = partition(comparator, low, high);

            quicksort(comparator, low, pi - 1);
            quicksort(comparator, pi + 1, high);
        }
    }

    private int partition(Comparator<Student> comparator, int low, int high) {
        Student pivot = iDNumber[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(iDNumber[j], pivot) > 0) {
                i++;

                Student temp = iDNumber[i];
                iDNumber[i] = iDNumber[j];
                iDNumber[j] = temp;
            }
        }

        Student temp = iDNumber[i + 1];
        iDNumber[i + 1] = iDNumber[high];
        iDNumber[high] = temp;

        return i + 1;
    }

    // Метод для вывода массива студентов
    public void outArray() {
        for (Student student : iDNumber) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " { gpa: " + student.getGPA() +" , Курс: "+student.getCourse()+"}");
        }
    }

    // Добавьте возможность сортировать список студентов по другому полю
    public void sortByField(Comparator<Student> comparator) {
        quicksort(comparator, 0, iDNumber.length - 1);
    }

    public static void main(String[] args) {
        // Пример использования

        // Создаем массив студентов
        Student[] students = {
                new Student("Иван", "Иванов", "Информатика", 2, "Группа-1", 4.5),
                new Student("Петр", "Петров", "Математика", 3, "Группа-2", 4.8),
                new Student("Мария", "Сидорова", "Физика", 1, "Группа-3", 4.2)
        };

        SortingStudentsByGPA sorter = new SortingStudentsByGPA(students.length);

        // Заполняем массив студентами
        sorter.setArray(students);

        // Сортируем по среднему баллу
        sorter.quicksort(Comparator.comparing(Student::getGPA).reversed(), 0, students.length - 1);

        // Выводим отсортированный массив
        System.out.println("Студенты, отсортированные по GPA:");
        sorter.outArray();

        // Сортируем по другому полю (например, по курсу)
        sorter.sortByField(Comparator.comparing(Student::getCourse));

        // Выводим отсортированный массив
        System.out.println("\nСтуденты, отсортированные по курсу:");
        sorter.outArray();
    }
}
