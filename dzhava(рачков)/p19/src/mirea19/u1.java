package mirea19;

import java.util.regex.Pattern;

public class u1 {
    public static void main(String[] args) {
        String validINN = "7707083893";
        String invalidINN = "123456789";

        try {
            // Проверка действительности ИНН
            if (isINNValid(validINN)) {
                System.out.println("Действительный ИНН: " + validINN);
            } else {
                throw new Exception("Недействительный ИНН: " + validINN);
            }

            if (isINNValid(invalidINN)) {
                System.out.println("Действительный ИНН: " + invalidINN);
            } else {
                throw new Exception("Недействительный ИНН: " + invalidINN);
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static boolean isINNValid(String inn) {
        if (!Pattern.matches("\\d{10}|\\d{12}", inn)) {
            return false;
        }

        // Для 10-значных ИНН проверяем контрольную сумму
        if (inn.length() == 10) {
            int[] coefficients = {2, 4, 10, 3, 5, 9, 4, 6, 8};
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(inn.charAt(i)) * coefficients[i]; // Вычисляем контрольную сумму
            }
            int remainder = sum % 11;
            remainder = remainder == 10 ? 0 : remainder;
            return remainder == Character.getNumericValue(inn.charAt(9)); // Сравниваем с контрольной цифрой
        }

        // Для 12-значных ИНН проверяем контрольные суммы для 10 и 12 символов
        if (inn.length() == 12) {
            int[] coefficients1 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
            int[] coefficients2 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 10; i++) {
                sum1 += Character.getNumericValue(inn.charAt(i)) * coefficients1[i]; // Вычисляем контрольную сумму
                sum2 += Character.getNumericValue(inn.charAt(i)) * coefficients2[i]; // Вычисляем вторую контрольную сумму
            }
            int remainder1 = sum1 % 11;
            int remainder2 = sum2 % 11;
            remainder1 = remainder1 == 10 ? 0 : remainder1;
            remainder2 = remainder2 == 10 ? 0 : remainder2;
            return remainder1 == Character.getNumericValue(inn.charAt(10)) && remainder2 == Character.getNumericValue(inn.charAt(11)); // Сравниваем с контрольными цифрами
        }

        return false;
    }
}