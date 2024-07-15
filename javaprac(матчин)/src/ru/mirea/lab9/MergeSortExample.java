package ru.mirea.lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSortExample {

    public static void main(String[] args) {
        // Создаем два списка данных о студентах
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("John", 3.8));
        list1.add(new Student("Jane", 3.5));
        list1.add(new Student("Bob", 4.0));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("Alice", 3.9));
        list2.add(new Student("Eve", 3.2));

        // Объединяем и сортируем списки
        List<Student> mergedList = mergeSort(list1, list2);

        // Выводим результат
        for (Student student : mergedList) {
            System.out.println(student);
        }
    }

    public static List<Student> mergeSort(List<Student> list1, List<Student> list2) {
        List<Student> mergedList = new ArrayList<>();

        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).getGpa() > list2.get(j).getGpa()) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        // Используем компаратор для сортировки по убыванию
        mergedList.sort(Comparator.comparingDouble(Student::getGpa).reversed());

        return mergedList;
    }

    public static class Student {
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

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", gpa=" + gpa +
                    '}';
        }
    }
}
