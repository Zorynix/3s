package ru.mirea.dashish17;

// Создаем пользовательское исключение для недействительного ИНН
class InvalidINNException extends Exception {
    public InvalidINNException(String message) {
        super(message);
    }
}

// Класс, представляющий клиента
class Client {
    private String fullName;
    private String INN;

    public Client(String fullName, String INN) {
        this.fullName = fullName;
        this.INN = INN;
    }

    // Метод для проверки действительности ИНН
    public void validateINN() throws InvalidINNException {
        // В данном примере, просто проверяем длину ИНН (допустимо, если это не реальная проверка)

        if (INN.length() != 10 && INN.length() != 12) {
            throw new InvalidINNException("Недействительный ИНН");
        }
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        try {
            // Пример создания клиента с ИНН
            Client client = new Client("Иванов Иван Иванович", "123456789");

            // Пытаемся проверить ИНН
            client.validateINN();
            System.out.println("ИНН действителен");

        } catch (InvalidINNException e) {
            System.out.println(e.getMessage());
        }
    }
}

