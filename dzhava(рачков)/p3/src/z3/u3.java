package z3;

// Класс Employee
class Employee {
    private String fullname;  // имя сотрудника
    private double salary;    // зарплата сотрудника

    public Employee(String fullname, double salary) {
        this.fullname = fullname;
        this.salary = salary;
    }

    public String getFullname() {  // Геттер для получения имени сотрудника
        return fullname;
    }

    public double getSalary() {    // Геттер для получения зарплаты сотрудника
        return salary;
    }
}

// Класс Report
class Report {
    // Статический метод для генерации отчета
    public static void generateReport(Employee[] employees) {  // Статический метод, принимающий массив сотрудников
        System.out.println("Отчет о сотрудниках:");  // Вывод заголовка отчета
        System.out.printf("%-20s %10s%n", "ФИО", "Зарплата");  // Вывод заголовков столбцов с выравниванием
        System.out.println("==================================");  // Вывод разделительной строки
        for (Employee employee : employees) {  // Цикл для обхода массива сотрудников
            System.out.printf("%-20s %,10.2f%n", employee.getFullname(), employee.getSalary());  // Вывод данных о сотруднике с форматированием
        }
    }
}

public class u3 {
    public static void main(String[] args) {
        // Создаем массив объектов класса Employee
        Employee[] employees = new Employee[3];  // Создание массива с тремя элементами
        employees[0] = new Employee("Иванов Иван Иванович", 50000.50);  // Инициализация элементов массива объектами Employee
        employees[1] = new Employee("Петров Петр Петрович", 60000.75);
        employees[2] = new Employee("Сидоров Сидор Сидорович", 45000.25);

        // Генерируем отчет
        Report.generateReport(employees);  // Вызов статического метода generateReport для вывода отчета
    }
}
