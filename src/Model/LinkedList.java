package Model;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void appendToTail(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T findByValue(T value) {
        Node<T> current = head;
        while (current != null) { 
            if (current.getValue().equals(value)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteByValue(T value) {
        if (head == null) return;

        if (head.getValue().equals(value)) {
            head = head.getNext();
            if (head == null) tail = null; 
            size--;
            return;
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(value)) {
                if (current.getNext() == tail) {
                    tail = current;
                }
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("Lista vacía.");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }
}
