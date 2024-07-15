package mirea17;
public class MVCPatternDemo1 {
    public static void main(String[] args) {
        //извлечь имя студента из базы данных на основе RollNo
        Student1 model = retriveStudentFromDatabase();
        //создать представление: для записи сведений о студенте в консоль
        StudentView1 view = new StudentView1();
        StudentController1 controller = new StudentController1(model, view);
        controller.updateView();
        //обновить данные модели
        controller.setStudentName("Ivan");
        System.out.println("After updating, Student Details are as follows");
        controller.updateView();
    }
    private static Student1 retriveStudentFromDatabase(){
        Student1 student = new Student1();
        student.setName("Petya");
        student.setRollNo("01");
        return student;
    }
}

