package ru.mirea.dashish21;
import java.util.NoSuchElementException;

public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    E peek();
    boolean isEmpty();
    int size();
}

abstract class AbstractQueue<E> implements Queue<E> {
    protected int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public abstract void enqueue(E element);

    public abstract E dequeue();

    public abstract E peek();
}

class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}

