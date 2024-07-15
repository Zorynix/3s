package mirea17;

public class Main2 {
    public static void main(String[] args) {
        // Создаем объекты модели, представления и контроллера
        Employee2 employee = new Employee2("Иван", 20.0, 40);
        EmployeeView2 view = new EmployeeView2();
        EmployeeController2 controller = new EmployeeController2(employee, view);

        // Выводим информацию о сотруднике
        controller.updateEmployeeView();
    }
}