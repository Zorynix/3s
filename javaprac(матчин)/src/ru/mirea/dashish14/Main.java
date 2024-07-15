package ru.mirea.dashish14;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Интерфейс ожидающего списка.
 *
 * @param <E> тип элементов в списке
 */
interface IWaitList<E> {
    void add(E element);

    E remove();

    boolean contains(E element);

    boolean containsAll(Collection<E> c);

    boolean isEmpty();
}

/**
 * Список ожидания.
 *
 * @param <E> тип элементов в списке
 */
class WaitList<E> implements IWaitList<E> {
    protected ConcurrentLinkedQueue<E> content;

    /**
     * Конструктор для создания пустого списка ожидания.
     */
    public WaitList() {
        this.content = new ConcurrentLinkedQueue<>();
    }

    /**
     * Конструктор для создания списка ожидания из коллекции.
     *
     * @param c коллекция для инициализации списка ожидания
     */
    public WaitList(Collection<E> c) {
        this.content = new ConcurrentLinkedQueue<>(c);
    }

    // Реализация методов интерфейса IWaitList

    /**
     * Добавляет элемент в список ожидания.
     *
     * @param element добавляемый элемент
     */
    @Override
    public void add(E element) {
        content.add(element);
    }

    /**
     * Удаляет и возвращает элемент из списка ожидания.
     *
     * @return удаленный элемент
     */
    @Override
    public E remove() {
        return content.poll();
    }

    /**
     * Проверяет, содержит ли список ожидания указанный элемент.
     *
     * @param element элемент для проверки
     * @return true, если элемент содержится в списке, иначе false
     */
    @Override
    public boolean contains(E element) {
        return content.contains(element);
    }

    /**
     * Проверяет, содержит ли список ожидания все элементы из указанной коллекции.
     *
     * @param c коллекция элементов для проверки
     * @return true, если список содержит все элементы из коллекции, иначе false
     */
    @Override
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }

    /**
     * Проверяет, пуст ли список ожидания.
     *
     * @return true, если список пуст, иначе false
     */
    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }

    /**
     * Возвращает строковое представление списка ожидания.
     *
     * @return строковое представление списка ожидания
     */
    @Override
    public String toString() {
        return content.toString();
    }
}

class BoundedWaitList<E> extends WaitList<E> {
    private int capacity;

    /**
     * Конструктор для создания ограниченного списка ожидания с заданной вместимостью.
     *
     * @param capacity вместимость списка ожидания
     */
    public BoundedWaitList(int capacity) {
        super();
        this.capacity = capacity;
    }

    // Дополнительные методы

    /**
     * Получает вместимость списка ожидания.
     *
     * @return вместимость списка ожидания
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Добавляет элемент в список ожидания, если емкость не превышена.
     *
     * @param element добавляемый элемент
     */
    @Override
    public void add(E element) {
        if (content.size() < capacity) {
            super.add(element);
        } else {
            System.out.println("Список заполнен, элемент не может быть добавлен.");
        }
    }
}

class UnfairWaitList<E> extends WaitList<E> {
    /**
     * Конструктор для создания несправедливого списка ожидания.
     */
    public UnfairWaitList() {
        super();
    }

    // Дополнительные методы

    /**
     * Удаляет указанный элемент из списка ожидания.
     *
     * @param element удаляемый элемент
     */
    public void remove(E element) {
        content.remove(element);
    }

    /**
     * Перемещает указанный элемент в конец списка ожидания.
     *
     * @param element перемещаемый элемент
     */
    public void moveToBack(E element) {
        if (content.remove(element)) {
            content.add(element);
        }
    }

    /**
     * Удаляет первое вхождение указанного элемента из списка ожидания.
     *
     * @param element элемент для удаления
     */
    public void removeFirstOccurrence(E element) {
        content.remove(element);
    }
}

public class Main {
    public static void main(String[] args) {
        BoundedWaitList<Integer> boundedWaitList = new BoundedWaitList<>(5);
        boundedWaitList.add(1);
        boundedWaitList.add(2);
        boundedWaitList.add(3);
        boundedWaitList.add(4);
        boundedWaitList.add(5);
        boundedWaitList.add(6); // Не добавится из-за ограничения вместимости

        System.out.println("Bounded Wait List: " + boundedWaitList);

        UnfairWaitList<String> unfairWaitList = new UnfairWaitList<>();
        unfairWaitList.add("A");
        unfairWaitList.add("B");
        unfairWaitList.add("C");
        unfairWaitList.add("D");
        unfairWaitList.add("C");
        System.out.println("Unfair Wait List: " + unfairWaitList);

        unfairWaitList.remove("B");
        System.out.println("После удаления 'B' из Unfair Wait List: " + unfairWaitList);

        unfairWaitList.moveToBack("A");
        System.out.println("После перемещения 'A' в конец Unfair Wait List: " + unfairWaitList);

        unfairWaitList.removeFirstOccurrence("C");
        System.out.println("После удаления первого вхождения 'C' в Unfair Wait List: " + unfairWaitList);
    }
}

