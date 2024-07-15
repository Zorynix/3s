package ru.mirea.lab4.task4;

public class Main {
    public static void main(String[] args) {
        Processor intelProcessor = new Processor("Intel i7", 4);
        Memory kingstonMemory = new Memory(8);
        Monitor lgMonitor = new Monitor("LG UltraWide", 29);

        Computer myComputer = new Computer(Brand.ASUS, intelProcessor, kingstonMemory, lgMonitor);

        System.out.println("My Computer:");
        System.out.println("Brand: " + myComputer.getBrand());
        System.out.println("Processor: " + myComputer.getProcessor().getModel() + ", Cores: " + myComputer.getProcessor().getCores());
        System.out.println("Memory: " + myComputer.getMemory().getSize() + "GB");
        System.out.println("Monitor: " + myComputer.getMonitor().getModel() + ", Size: " + myComputer.getMonitor().getSizeInInches() + " inches");
    }
}
