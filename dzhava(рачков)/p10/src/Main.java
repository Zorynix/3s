import java.util.ArrayList;
import java.util.Comparator; // для сравнения объектов.
import java.util.List;
import java.util.Collections; // для сортировки коллекций.

class Student {
    private String firstName; // имя студента.
    private String lastName; // фамилия студента.
    private String specialty; // специальность студента.
    private int course; // курс студента.
    private String group; // группа студента.

    public Student(String firstName, String lastName, String specialty, int course, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}

class SortingStudentsByGPA {
    private List<Student> studentList = new ArrayList<>(); // Создание списка студентов с использованием ArrayList.

    public void setArray(List<Student> students) { // Метод для установки массива студентов в список.
        studentList.addAll(students);
    }

    public void quickSort(Comparator<Student> comparator) { // Метод для быстрой сортировки списка студентов с использованием переданного компаратора.
        Collections.sort(studentList, comparator);
    }

    public void outArray() { // Метод для вывода списка студентов.
        for (Student student : studentList) { // Итерация по списку студентов.
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName()); // Вывод имени и фамилии студента.
            System.out.println("Specialty: " + student.getSpecialty()); // Вывод специальности студента.
            System.out.println("Course: " + student.getCourse()); // Вывод курса студента.
            System.out.println("Group: " + student.getGroup()); // Вывод группы студента.
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание и заполнение двух списков студентов.
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("John", "Doe", "Computer Science", 3, "CS101"));
        list1.add(new Student("Jane", "Smith", "Mathematics", 2, "Math201"));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("Alice", "Johnson", "Physics", 4, "Phys401"));
        list2.add(new Student("Bob", "Brown", "Biology", 1, "Bio101"));

        // Объединение двух списков студентов в один.
        List<Student> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);

        // Создание экземпляра SortingStudentsByGPA и установка списка студентов.
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.setArray(mergedList);

        // Сортировка студентов по курсу в порядке убывания и вывод списка.
        sorter.quickSort((student1, student2) -> {
            return student2.getCourse() - student1.getCourse();
        });
        //sorter.quicksort( - Здесь мы вызываем метод quicksort из объекта sorter, который, как предполагается, выполняет сортировку списка студентов.
        //
        //(student1, student2) -> { return student2.getCourse() - student1.getCourse(); } - Это лямбда-выражение, которое определяет, как будут сравниваться студенты для сортировки.
        //
        //student1 и student2 - это параметры лямбда-функции, представляющие двух студентов, которые будут сравниваться.
        //
        //student2.getCourse() - student1.getCourse() - Это выражение считает разницу между курсами (getCourse() возвращает номер курса для каждого студента). Если результат этой разницы положителен, то student2 будет считаться "больше" чем student1, и они будут меняться местами при сортировке, что создаст порядок убывания курсов.
        //
        //); - Закрывающая скобка и точка с запятой завершают вызов метода quicksort.

        sorter.outArray(); // Вывод отсортированного списка студентов.
    }
}