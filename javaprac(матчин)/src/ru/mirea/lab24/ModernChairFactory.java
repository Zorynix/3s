package ru.mirea.lab24;

public class ModernChairFactory extends AbstractChairFactory {
    @Override
    public Chair createVictorianChair() {
        return new VictorianChair();
    }

    @Override
    public Chair createMultifunctionalChair() {
        return new MultifunctionalChair();
    }

    @Override
    public Chair createMagicChair() {
        return new MagicChair();
    }
}
