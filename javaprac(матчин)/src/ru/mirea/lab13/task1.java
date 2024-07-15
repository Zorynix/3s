// Объявление пакета, в котором находится класс Shirt
package ru.mirea.lab13;

// Определение класса Shirt
class Shirt {
    // Приватные поля класса Shirt
    private String code;
    private String description;
    private String color;
    private String size;

    // Конструктор класса Shirt, принимающий параметры code, description, color, size
    public Shirt(String code, String description, String color, String size) {
        this.code = code;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Code: " + code + "\nDescription: " + description + "\nColor: " + color + "\nSize: " + size + "\n";
    }
}

// Определение класса task1
public class task1 {
    // Главный метод программы
    public static void main(String[] args) {
        // Массив строк с данными о рубашках
        String[] shirtsData = {
                "S001,Black Polo Shirt,Black,XL", "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL", "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL", "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL", "S008,White T-Shirt,White,L",
                "S009,Green T Shirt,Green,S", "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };

        // Создание массива объектов класса Shirt
        Shirt[] shirts = new Shirt[shirtsData.length];

        // Заполнение массива объектами Shirt, созданными на основе данных из строк shirtsData
        for (int i = 0; i < shirtsData.length; i++) {
            String[] shirtInfo = shirtsData[i].split(",");
            shirts[i] = new Shirt(shirtInfo[0], shirtInfo[1], shirtInfo[2], shirtInfo[3]);
        }

        // Вывод информации о каждой рубашке
        for (Shirt shirt : shirts) {
            System.out.println(shirt);
        }
    }
}
