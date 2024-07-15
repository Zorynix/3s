package mirea13;

class Shirt {
    private String code; //код
    private String name; //название
    private String color;//цвет
    private String size; //размер

    public Shirt(String code, String name, String color, String size) {
        this.code = code;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Код: " + code + "\nНазвание: " + name + "\nЦвет: " + color + "\nРазмер: " + size;
    }
}

public class u4 {
    public static void main(String[] args) {
        // Исходные данные о рубашках
        String[] shirtsData = new String[11];
        shirtsData[0] = "S001,Black Polo Shirt,Black,XL";
        shirtsData[1] = "S002,Black Polo Shirt,Black,L";
        shirtsData[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirtsData[3] = "S004,Blue Polo Shirt,Blue,M";
        shirtsData[4] = "S005,Tan Polo Shirt,Tan,XL";
        shirtsData[5] = "S006,Black T-Shirt,Black,XL";
        shirtsData[6] = "S007,White T-Shirt,White,XL";
        shirtsData[7] = "S008,White T-Shirt,White,L";
        shirtsData[8] = "S009,Green T-Shirt,Green,S";
        shirtsData[9] = "S010,Orange T-Shirt,Orange,S";
        shirtsData[10] = "S011,Maroon Polo Shirt,Maroon,S";

        Shirt[] shirts = new Shirt[shirtsData.length];

        // Заполнение массива объектов класса Shirt на основе данных из shirtsData
        for (int i = 0; i < shirtsData.length; i++) {
            String[] shirtInfo = shirtsData[i].split(",");
            shirts[i] = new Shirt(shirtInfo[0], shirtInfo[1], shirtInfo[2], shirtInfo[3]);
        }

        // Вывод информации о каждой рубашке на консоль
        for (Shirt shirt : shirts) {
            System.out.println(shirt.toString());
            System.out.println();
        }
    }
}