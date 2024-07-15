package mirea19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    private String Name;
    private double SredBall;

    public Student(String Name, double SredBall) {
        this.Name = Name;
        this.SredBall = SredBall;
    }

    public String getName() {
        return Name;
    }

    public double getSredBall() {
        return SredBall;
    }

    @Override
    public String toString() {
        return "Студент " + Name + ", средний балл=" + SredBall;
    }
}

// Класс для сортировки и поиска студентов
class StudentManager {
    private List<Student> studentList;

    // Конструктор класса StudentManager
    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    // Метод для добавления студента в список
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // Метод для сортировки студентов по среднему баллу
    public void sortStudentsByAverageGrade() {
        Collections.sort(studentList, Comparator.comparingDouble(Student::getSredBall));
    }

    // Метод для поиска студента по ФИО с обработкой исключения
    public Student findStudentByFullName(String fullName) throws StudentNotFoundException {
        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(fullName)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Студент '" + fullName + "' не найден.");
    }
}

// Исключение для случая, когда студент не найден по ФИО
class StudentNotFoundException extends Exception {
    // Конструктор класса исключения
    public StudentNotFoundException(String message) {
        super(message);
    }
}

// Пользовательский интерфейс
public class u2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        // Добавление нескольких студентов в список
        studentManager.addStudent(new Student("Иванов Иван Иванович", 85.5));
        studentManager.addStudent(new Student("Петрова Маша Петровна", 92.0));
        studentManager.addStudent(new Student("Сидоров Алексей Владимирович", 78.3));

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Сортировка студентов по среднему баллу");
            System.out.println("2. Поиск студента по ФИО");
            System.out.println("3. Выйти из программы");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    // Сортировка студентов по среднему баллу и вывод на экран
                    studentManager.sortStudentsByAverageGrade();
                    System.out.println("Студенты отсортированы по среднему баллу:");
                    for (Student student : studentManager.getStudentList()) {
                        System.out.println(student);
                    }
                    break;
                case 2:
                    // Ввод ФИО и поиск студента, обработка исключения, если не найден
                    System.out.print("Введите ФИО студента: ");
                    String fullName = scanner.nextLine();
                    try {
                        Student foundStudent = studentManager.findStudentByFullName(fullName);
                        System.out.println("Найден студент: " + foundStudent);
                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    // Завершение программы
                    System.out.println("Программа завершена.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неправильный выбор. Попробуйте снова.");
            }
        }
    }
}
