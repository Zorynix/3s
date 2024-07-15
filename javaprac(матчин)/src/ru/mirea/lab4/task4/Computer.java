package ru.mirea.lab4.task4;

// Класс, представляющий компьютер
class Computer {
    private Brand brand;       // Марка компьютера
    private Processor processor;   // Процессор компьютера
    private Memory memory;       // Память компьютера
    private Monitor monitor;     // Монитор компьютера

    // Конструктор для инициализации компонента компьютера
    public Computer(Brand brand, Processor processor, Memory memory, Monitor monitor) {
        this.brand = brand;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
    }

    // Метод для получения марки компьютера
    public Brand getBrand() {
        return brand;
    }

    // Метод для получения процессора компьютера
    public Processor getProcessor() {
        return processor;
    }

    // Метод для получения памяти компьютера
    public Memory getMemory() {
        return memory;
    }

    // Метод для получения монитора компьютера
    public Monitor getMonitor() {
        return monitor;
    }
}
