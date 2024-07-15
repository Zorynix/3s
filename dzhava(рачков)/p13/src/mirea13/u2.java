package mirea13;

public class u2 {
    private String lastName;     // Фамилия
    private String firstName;    // Имя
    private String middleName;   // Отчество

    public u2(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    // Метод для формирования Фамилии И.О.
    public String getFullName() {
        // Создаем объект StringBuilder для эффективной конкатенации строк
        StringBuilder fullName = new StringBuilder();

        // Добавляем фамилию всегда, так как она обязательна
        fullName.append(lastName);

        if (firstName != null && !firstName.isEmpty()) {
            fullName.append(" ").append(firstName.charAt(0)).append(".");
        }

        if (middleName != null && !middleName.isEmpty()) {
            fullName.append(" ").append(middleName.charAt(0)).append(".");
        }

        // Преобразуем объект StringBuilder в строку
        return fullName.toString();
    }

    public static void main(String[] args) {
        u2 person1 = new u2("Иванов", "Иван", "Иванович");
        u2 person2 = new u2("Петров", "Петр", null);
        u2 person3 = new u2("Сидоров", null, null);

        System.out.println(person1.getFullName());
        System.out.println(person2.getFullName());
        System.out.println(person3.getFullName());
    }
}