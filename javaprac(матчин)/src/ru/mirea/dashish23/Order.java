package ru.mirea.dashish23;
public class Order {
    private int size;
    private Node first;
    private Node last;

    private class Node {
        private Node next;
        private Node prev;
        private Item item;

        Node(Item item) {
            this.item = item;
            next = null;
            prev = null;
        }
        Node(Node next, Node last, Item item) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    public Order() {
        size = 0;
    }

    public boolean addFirst(Item item) {
        if (item != null) {
            if (this.first == null) {
                this.first = new Node(item);
                this.first.prev = this.first.next = this.first;
                this.last = this.first;
            } else {
                Node node = new Node(this.first, this.last, item);
                this.last.next = this.first.prev = node;
                node.next = first;
                this.first = node;
            }
            size++;
            return true;
        }
        return false;
    }
    public boolean addLast(Item item) {
        if (item != null) {
            if (first == null) {
                addFirst(item);
            } else {
                Node node = new Node(this.first, this.last, item);
                this.first.prev = this.last.next = node;
                node.prev = last;
                this.last = node;
                this.size++;
            }
            return true;
        }
        return false;
    }

    public boolean removeFirst() {
        if (size > 0) {
            if (size == 1) {
                first = null;
                last = null;
                size = 0;
            } else {
                Node first_new = first.next;
                first_new.prev = last;
                last.next = first_new;
                first = first_new;
                size--;
            }
            return true;
        }
        return false;
    }

    public boolean removeLast() {
        if (size > 0) {
            if (this.size == 1) {
                first = null;
                last = null;
                size = 0;
            } else {
                Node last_new = this.last.prev;
                last_new.next = this.first;
                this.first.prev = last_new;
                this.last = last_new;
                this.size--;
            }
            return true;
        }
        return false;
    }

    public boolean add(Item item) {
        return addLast(item);
    }

    public boolean remove(String dishName) {
        if (size > 0) {
            Node node = this.last.next;
            do {
                Node del = node;
                if (dishName.equals(node.item.getName())) {
                    if (del == first) {
                        last.next = first =  del.next;
                    }
                    if (del == last) {
                        last = first.prev = del.prev;
                    }
                    del.prev.next = del.next;
                    del.next.prev = del.prev;
                    this.size--;
                    return true;
                }
                node = node.prev;
            } while (node != this.first);
        }
        return false;
    }
}
