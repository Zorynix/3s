package mirea24;

// Интерфейс для всех типов стульев
interface Chair {
    void sit();
}

// Викторианский стул
class VictorianChair implements Chair {
    private int age;

    public VictorianChair(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void sit() {
        System.out.println("Вы сели на викторианский стул.");
    }
}

// Многофункциональный стул
class FunctionalChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Вы сели на многофункциональный стул.");
    }

    public int sum(int a, int b) {
        return a + b;
    }
}

// Магический стул
class MagicalChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Вы сели на магический стул.");
    }

    public void doMagic() {
        System.out.println("Вы активировали магический эффект на стуле.");
    }
}

// Абстрактная фабрика для создания стульев
abstract class ChairFactory {
    public abstract VictorianChair createVictorianChair(int age);
    public abstract FunctionalChair createFunctionalChair();
    public abstract MagicalChair createMagicalChair();
}

// Фабрика для создания викторианских стульев
class VictorianChairFactory extends ChairFactory {
    // Метод для создания викторианского стула с указанием возраста
    @Override
    public VictorianChair createVictorianChair(int age) {
        return new VictorianChair(age);
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return null;
    }

    @Override
    public MagicalChair createMagicalChair() {
        return null;
    }
}

// Фабрика для создания многофункциональных стульев
class FunctionalChairFactory extends ChairFactory {
    // Метод не поддерживается для многофункциональных стульев
    @Override
    public VictorianChair createVictorianChair(int age) {
        return null;
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }

    @Override
    public MagicalChair createMagicalChair() {
        return null;
    }
}

// Фабрика для создания магических стульев
class MagicalChairFactory extends ChairFactory {
    @Override
    public VictorianChair createVictorianChair(int age) {
        return null;
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return null;
    }

    @Override
    public MagicalChair createMagicalChair() {
        return new MagicalChair();
    }
}

// Клиентский класс
class Client {
    private Chair chair;

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public void sit() {
        if (chair != null) {
            chair.sit();
        } else {
            System.out.println("Сначала установите стул.");
        }
    }
}


public class u2 {
    public static void main(String[] args) {
        // Создание фабрик
        ChairFactory victorianFactory = new VictorianChairFactory();
        ChairFactory multifunctionalFactory = new FunctionalChairFactory();
        ChairFactory magicalFactory = new MagicalChairFactory();

        Client client = new Client();

        // Использование фабрик для создания и установки стульев
        VictorianChair victorianChair = victorianFactory.createVictorianChair(50);
        client.setChair(victorianChair);
        client.sit();

        FunctionalChair multifunctionalChair = multifunctionalFactory.createFunctionalChair();
        client.setChair(multifunctionalChair);
        client.sit();

        MagicalChair magicalChair = magicalFactory.createMagicalChair();
        client.setChair(magicalChair);
        client.sit();
    }
}