package ru.mirea.dashish23;
public class InternetOrder {
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
    public InternetOrder() {
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
    public int removeAll(String dishName) {
        int c = 0;
        if (size > 0) {
            Node node = this.first;
            do {
                if (this.remove(dishName)) c++;
                node = node.next;
            } while (node != this.first.next);
        }
        return c;
    }

    public int dishQuantity() {
        return size;
    }
    
    public int dishQuantity(String dishName) {
        int c = 0;
        if (size > 0) {
            Node node = this.first;
            do {
                if (dishName.equals(node.item.getName())) {
                    c++;
                }
                node = node.next;
            } while (node != this.first);
        }
        return c;
    }

    
    public Item[] getItems() {
        int c = 0;
        Node node = this.first;
        do {
            c++;
            node = node.next;
        } while (node != this.first);
        Item[] temp = new Item[c];
        c = 0;
        node = this.first;
        do {
            temp[c] = node.item;
            c++;
            node = node.next;
        } while (node != this.first);
        return temp;
    }

    
    public double costTotal() {
        int c = 0;
        Node node = this.first;
        do {
            c += node.item.getCost();
            node = node.next;
        } while (node != this.first);
        return c;
    }

    
    public String[] itemsName() {
        int c = 0, f = 0;
        String[] temp = new String[10000];
        Node node = this.first;
        do {
            f = 0;
            for (int j = 0; j < size; j++) {
                if (node.item.getName().equals(temp[j])) {
                    f = 1;
                    break;
                }
            }
            if (f == 0) {
                temp[c] = node.item.getName();
                c++;
            }

            node = node.next;
        } while (node != this.first);

        String[] temp_main = new String[c];
        c = 0;
        for (String i : temp) {
            if (i != null) {
                temp_main[c] = i;
                c++;
            }
        }
        return temp_main;
    }


    
    public Item[] sortedItemsByCost() {
        Item[] arr = new Item[size];
        int i =0;
        Node node = this.first;
        do {
            arr[i] = node.item;
            i++;
            node = node.next;
        } while (node != this.first);

        for (i = 0; i < size - 1; i++) {
            for(int j = 0; j < size - i - 1; j++) {
                if(arr[j + 1].getCost() > arr[j].getCost()) {
                    Item swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
        return arr;
    }

    public void testPrint() {
        Node node = this.first;
        do {
            System.out.println(node.item.getName() + "; "  + node.item.getDescription());
            node = node.next;
        } while (node != this.first);
    }
}
