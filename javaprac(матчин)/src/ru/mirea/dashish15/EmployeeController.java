package ru.mirea.dashish15;

// Класс EmployeeController (Контроллер)
public class EmployeeController {
    private Employee model;
    private EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.printEmployeeDetails(model.getName(), model.getHourlyRate(), model.getHoursWorked(), model.calculateSalary());
    }
}
