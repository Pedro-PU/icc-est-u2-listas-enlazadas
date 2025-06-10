package Model;

public class LinkedList <T>{
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
            return;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        size ++;
    }

    public T findByValue(T value){
        Node<T> current = head;
        while(current.getNext() != null){
            if(current.getValue().equals(value)){
                return current.getValue();
            }
        }
        return null;
    }

    public void deleteByValue(T value) {
        if (head == null)
            return;

        if (head.getValue().equals(value)) {
            head = head.getNext();
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
            System.out.println("END");
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            System.out.print(current.getValue() + " -> ");
            current = current.getNext();
        }
        System.out.println(current.getValue() + " -> END");
    }
    
    public int getSize() {
        return size;
    }
}
