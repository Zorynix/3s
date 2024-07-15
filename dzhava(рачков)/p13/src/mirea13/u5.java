package mirea13;

public class u5 {
    // Метод для преобразования строки с номером телефона
    public String convertPhoneNumber(String phoneNumber) {
        // Удаление лишних символов, таких как пробелы или тире
        phoneNumber = phoneNumber.replaceAll("[\\s-]+", "");
        //"\\s" представляет собой регулярное выражение для пробелов.
        //"-" представляет символ тире.
        //"[\\s-]+" - это регулярное выражение, которое соответствует одному или более пробелам или тире подряд.

        // Проверка наличия символа "+" в начале номера
        if (phoneNumber.startsWith("+")) {
            String countryCode = phoneNumber.substring(1, 4);
            String restOfNumber = phoneNumber.substring(4);

            // Формируем строку в требуемом формате
            return "+" + countryCode + "-" + restOfNumber.substring(0, 3) + "-" + restOfNumber.substring(3, 6) + "-" + restOfNumber.substring(6);
        } else if (phoneNumber.startsWith("8") && phoneNumber.length() == 11) {
            String restOfNumber = phoneNumber.substring(1);

            // Формируем строку в требуемом формате
            return "+7" + "-" + restOfNumber.substring(0, 3) + "-" + restOfNumber.substring(3, 6) + "-" + restOfNumber.substring(6);
        } else {
            // Неверный формат номера
            return "";
        }
    }

    public static void main(String[] args) {
        u5 converter = new u5();

        String phoneNumber1 = "+79175655655";
        String phoneNumber2 = "+104289652211";
        String phoneNumber3 = "89175655655";

        String formattedPhoneNumber1 = converter.convertPhoneNumber(phoneNumber1);
        String formattedPhoneNumber2 = converter.convertPhoneNumber(phoneNumber2);
        String formattedPhoneNumber3 = converter.convertPhoneNumber(phoneNumber3);

        System.out.println("Преобразованный номер 1: " + formattedPhoneNumber1);
        System.out.println("Преобразованный номер 2: " + formattedPhoneNumber2);
        System.out.println("Преобразованный номер 3: " + formattedPhoneNumber3);
    }
}