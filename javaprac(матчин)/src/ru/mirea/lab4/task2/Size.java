package ru.mirea.lab4.task2;

// Перечисление, представляющее размеры одежды
public enum Size {
    XXS(32),  // Размер XXS с европейским размером 32
    XS(34),   // Размер XS с европейским размером 34
    S(36),    // Размер S с европейским размером 36
    M(38),    // Размер M с европейским размером 38
    L(40);    // Размер L с европейским размером 40

    private int euroSize; // Европейский размер

    // Конструктор перечисления с параметром (европейский размер)
    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    // Метод для получения описания размера (детский или взрослый)
    public String getDescription() {
        return this == XXS ? "Детский размер" : "Взрослый размер";
    }

    // Метод для получения европейского размера
    public int getEuroSize() {
        return euroSize;
    }
}
