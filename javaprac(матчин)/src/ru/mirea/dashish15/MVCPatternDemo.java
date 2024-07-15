package ru.mirea.dashish15;

// Student класс
class Student {
    private String rollNo;
    private String name;

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// StudentView класс
class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student:");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}

// StudentController класс
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}

// MVCPatternDemo класс
public class MVCPatternDemo {
    private static Student[] studentsDB = new Student[3]; // Имитация базы данных (массив студентов)

    public static void main(String[] args) {
        // Заполнение имитации базы данных
        studentsDB[0] = new Student();
        studentsDB[0].setName("Alice");
        studentsDB[0].setRollNo("1");

        studentsDB[1] = new Student();
        studentsDB[1].setName("Bob");
        studentsDB[1].setRollNo("2");

        studentsDB[2] = new Student();
        studentsDB[2].setName("Carol");
        studentsDB[2].setRollNo("3");

        // Создание вида и контроллера
        StudentView view = new StudentView();
        StudentController controller = new StudentController(studentsDB[0], view);

        controller.updateView();

        // Обновление модели данных
        controller.setStudentName("John");
        controller.setStudentRollNo("21");

        controller.updateView();
    }

    private static Student retriveStudentFromDatabase() {
        // Логика получения студента из базы данных
        return new Student();
    }
}

