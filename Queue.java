package musterrrs.SorterApp.doubleLinkedList;

import java.util.NoSuchElementException;

public class Queue <E> {
    private DoublyLinkedList<E> list;
    public Queue(){
        this.list = new DoublyLinkedList<>();
    }
    public void enqueue(E newElement) {
        if (newElement == null) {
            throw new IllegalArgumentException("Null kann nicht hinzufugen");
        }
        list.add(newElement);
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty () {
        return list.isEmpty();
    }
    public E dequeue() {
        if(size() == 0) {
            throw new NoSuchElementException("Queue ist leer");
        } return list.remove(0);
    }
    public E[] dequeue(int n ) {
        if(n<0 || n>size()) {
            throw new IllegalArgumentException("Fehler");
        }
        E[] result = (E[]) new Object[n];
        for (int i = 0; i<n; i++) {
            result[i] = this.dequeue();
        }
        return result;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return list.get(0);
    }

}
