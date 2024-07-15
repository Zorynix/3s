package z2;

public class u1 {
    public static void main(String[] args) {
        // 1. Создаем объекты класса Double, используя методы valueOf().
        Double doubleObject1 = Double.valueOf(3.14);  // Создаем объект Double и присваиваем ему значение 3.14
        Double doubleObject2 = Double.valueOf("2.718");  // Создаем объект Double и присваиваем ему значение, преобразованное из строки "2.718"

        // 2. Преобразуем значение типа String к типу double. Используем метод Double.parseDouble().
        String stringValue = "1.234";  // Создаем строковую переменную
        double doubleValue = Double.parseDouble(stringValue);  // Преобразуем строковое значение в тип double

        // 3. Преобразуем объект класса Double ко всем примитивным типам.
        double primDouble = doubleObject1.doubleValue();  // Преобразуем объект Double в тип double
        float primFloat = doubleObject1.floatValue();      // Преобразуем объект Double в тип float
        int primInt = doubleObject1.intValue();            // Преобразуем объект Double в тип int
        long primLong = doubleObject1.longValue();          // Преобразуем объект Double в тип long
        short primShort = doubleObject1.shortValue();      // Преобразуем объект Double в тип short
        byte primByte = doubleObject1.byteValue();          // Преобразуем объект Double в тип byte

        // 4. Выводим значение объекта Double на консоль.
        System.out.println("doubleObject1: " + doubleObject1);
        System.out.println("doubleObject2: " + doubleObject2);

        // 5. Преобразуем литерал типа double к строке: String d = Double.toString(3.14);
        String doubleToString = Double.toString(3.14);  // Преобразуем литерал double в строку
        System.out.println("doubleToString: " + doubleToString);
    }
}
