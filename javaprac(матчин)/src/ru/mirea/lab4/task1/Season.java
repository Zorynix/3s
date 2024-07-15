package ru.mirea.lab4.task1;

// Создаем перечисление Season, которое представляет собой времена года
public enum Season {
    SPRING(15),   // Весна с средней температурой 15 градусов
    SUMMER(25),   // Лето с средней температурой 25 градусов
    AUTUMN(10),   // Осень с средней температурой 10 градусов
    WINTER(0);    // Зима с средней температурой 0 градусов

    private int averageTemperature;  // Поле для хранения средней температуры времени года

    // Конструктор Season с параметром averageTemperature
    Season(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    // Метод для получения средней температуры
    public int getAverageTemperature() {
        return averageTemperature;
    }

    // Метод для получения описания времени года
    public String getDescription() {
        switch (this) {
            case SUMMER:
                return "Теплое время года"; // Лето описываем как теплое время года
            default:
                return "Холодное время года"; // Все остальные времена года описываем как холодные
        }
    }

    // Основной метод программы
    public static void main(String[] args) {
        for (Season season : Season.values()) {
            // Выводим информацию о времени года, его средней температуре и описании
            System.out.println("Время года: " + season +
                    ", Средняя температура: " + season.getAverageTemperature() +
                    ", Описание: " + season.getDescription());
        }
    }
}
