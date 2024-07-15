package mirea14;
//Проверить, надежно ли составлен пароль. Пароль считается
//надежным, если он состоит из 8 или более символов. Где символом может быть
//цифр, английская буква, и знак подчеркивания. Пароль должен содержать хотя
//бы одну заглавную букву, одну маленькую букву и одну цифру.
//a) пример правильных выражений: F032_Password, TrySpy1.
//b) пример неправильных выражений: smart_pass, A007.
public class u7 {
    public static void main(String[] args) {
        String password1 = "F032_Password"; // Надежный пароль
        String password2 = "smart_pass";    // Ненадежный пароль
        String password3 = "A007";          // Ненадежный пароль

        // Проверяем каждый пароль и выводим результат
        if (isValidPassword(password1)) {
            System.out.println(password1 + " - надежный пароль");
        } else {
            System.out.println(password1 + " - пароль недостаточно надежный");
        }

        if (isValidPassword(password2)) {
            System.out.println(password2 + " - надежный пароль");
        } else {
            System.out.println(password2 + " - пароль недостаточно надежный");
        }

        if (isValidPassword(password3)) {
            System.out.println(password3 + " - надежный пароль");
        } else {
            System.out.println(password3 + " - пароль недостаточно надежный");
        }
    }

    // Метод для проверки надежности пароля
    public static boolean isValidPassword(String password) {
        // Проверяем длину пароля (должен быть 8 символов или более)
        if (password.length() < 8) {
            return false;
        }

        // Проверяем наличие хотя бы одной заглавной буквы, одной маленькой буквы и одной цифры
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        // Проходим по каждому символу пароля
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true; // Если символ - заглавная буква, устанавливаем флаг hasUppercase в true
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true; // Если символ - маленькая буква, устанавливаем флаг hasLowercase в true
            } else if (Character.isDigit(c)) {
                hasDigit = true;     // Если символ - цифра, устанавливаем флаг hasDigit в true
            }
        }

        // Пароль считается надежным, если выполняются все три условия
        return hasUppercase && hasLowercase && hasDigit;
    }
}