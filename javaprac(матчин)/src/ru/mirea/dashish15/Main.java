package ru.mirea.dashish15;

// Пример использования
public class Main {
    public static void main(String[] args) {
        // Создаем сотрудника
        Employee employee = new Employee("Иван Иванов", 10.0, 40);

        // Создаем представление и контроллер
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(employee, view);

        // Выводим информацию о сотруднике
        controller.updateView();
    }
}
