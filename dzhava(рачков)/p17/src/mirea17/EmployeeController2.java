package mirea17;

// Класс EmployeeController (Контроллер)
public class EmployeeController2 {
    private Employee2 model;
    private EmployeeView2 view;

    public EmployeeController2(Employee2 model, EmployeeView2 view) {
        this.model = model;
        this.view = view;
    }

    public void updateEmployeeView() {
        String name = model.getName();
        double salary = model.calculateSalary();
        view.printEmployeeDetails(name, salary);
    }
}