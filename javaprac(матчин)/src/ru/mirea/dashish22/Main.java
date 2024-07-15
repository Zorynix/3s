package ru.mirea.dashish22;

// Импортируем пакет ru.mirea.lab24 для доступа к классам этого пакета.

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр фабрики стульев современного стиля.
        AbstractChairFactory factory = new ModernChairFactory();

        // Создаем стулья разных типов с помощью фабрики.
        Chair victorianChair = factory.createVictorianChair();
        Chair multifunctionalChair = factory.createMultifunctionalChair();
        Chair magicChair = factory.createMagicChair();

        // Создаем клиента.
        Client client = new Client();

        // Клиент садится на каждый из стульев.
        client.Sit(victorianChair);
        client.Sit(multifunctionalChair);
        client.Sit(magicChair);
    }
}
