package ru.mirea.lab13;

public class PhoneNumberConverter {
    private String phoneNumber;

    // Конструктор класса, принимающий строковое представление телефонного номера
    public PhoneNumberConverter(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Метод для преобразования номера в нужный формат
    public String convertToFormattedString() {
        String formattedNumber;

        // Убираем все нецифровые символы из строки
        String digitsOnly = phoneNumber.replaceAll("\\D", "");

        // Проверяем, если номер начинается с 8, то добавляем код страны России
        if (digitsOnly.startsWith("8")) {
            digitsOnly = "+7" + digitsOnly.substring(1);
        } else if (!digitsOnly.startsWith("+")) {
            digitsOnly = "+" + digitsOnly;
        }

        // Форматируем номер
        formattedNumber = digitsOnly.substring(0, 5) + "-" + digitsOnly.substring(5, 8) + "-" + digitsOnly.substring(8);

        return formattedNumber;
    }

    public static void main(String[] args) {
        // Примеры использования

        // Создаем объект с номером "+79175655655" и выводим его в нужном формате
        PhoneNumberConverter converter1 = new PhoneNumberConverter("+79175655655");
        System.out.println(converter1.convertToFormattedString());

        // Создаем объект с номером "+104289652211" и выводим его в нужном формате
        PhoneNumberConverter converter2 = new PhoneNumberConverter("+104289652211");
        System.out.println(converter2.convertToFormattedString());

        // Создаем объект с номером "89175655655" (российский формат) и выводим его в нужном формате
        PhoneNumberConverter converter3 = new PhoneNumberConverter("89175655655");
        System.out.println(converter3.convertToFormattedString());
    }
}
