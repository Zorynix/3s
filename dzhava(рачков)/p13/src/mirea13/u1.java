package mirea13;

public class u1 {
    public static void main(String[] args) {
        // Исходная строка
        String str = "I like Java!!!";

        // 2. Распечатать последний символ строки.
        char lastChar = str.charAt(str.length() - 1);
        System.out.println("Последний символ строки: " + lastChar);

        // 3. Проверить, заканчивается ли строка подстрокой "!!!".
        boolean endsWithExclamation = str.endsWith("!!!");
        System.out.println("Заканчивается ли строка на '!!!': " + endsWithExclamation);

        // 4. Проверить, начинается ли строка подстрокой "I like".
        boolean startsWithILike = str.startsWith("I like");
        System.out.println("Начинается ли строка с 'I like': " + startsWithILike);

        // 5. Проверить, содержит ли строка подстроку "Java".
        boolean containsJava = str.contains("Java");
        System.out.println("Содержит ли строка 'Java': " + containsJava);

        // 6. Найти позицию подстроки "Java" в строке.
        int javaIndex = str.indexOf("Java");
        System.out.println("Позиция подстроки 'Java': " + javaIndex);

        // 7. Заменить все символы "а" на "о".
        String replacedString = str.replace('a', 'o');
        System.out.println("Замененная строка: " + replacedString);

        // 8. Преобразовать строку к верхнему регистру.
        String upperCaseString = str.toUpperCase();
        System.out.println("Строка в верхнем регистре: " + upperCaseString);

        // 9. Преобразовать строку к нижнему регистру.
        String lowerCaseString = str.toLowerCase();
        System.out.println("Строка в нижнем регистре: " + lowerCaseString);

        // 10. Вырезать строку "Java" с помощью substring.
        String substring = str.substring(7, 11);
        System.out.println("Вырезанная подстрока: " + substring);
    }
}
