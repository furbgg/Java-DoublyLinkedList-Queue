package musterrrs.SorterApp.doubleLinkedList;


import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {


    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> previous;

        public Node(E value) {
            this.value = value;
        }
    }


    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }


    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    public E get(int index) {
        return getNode(index).value;
    }


    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> nodeToRemove = getNode(index);

        if (size == 1) {
            head = null;
            tail = null;
        } else if (nodeToRemove == head) {
            head = head.next;
            head.previous = null;
        } else if (nodeToRemove == tail) {
            tail = tail.previous;
            tail.next = null;
        } else {
            Node<E> prevNode = nodeToRemove.previous;
            Node<E> nextNode = nodeToRemove.next;
            prevNode.next = nextNode;
            nextNode.previous = prevNode;
        }

        size--;
        return nodeToRemove.value;
    }
    public void addIndex ( int index , E element) {
        if (index<0 || index>size) {
            throw new IndexOutOfBoundsException("Index : " + index + ", Size" + size);
        }
      if (index == size) {
          add(element);
          return;
      }
      Node<E> newNode = new Node<>(element);
      if (index == 0) {
          newNode.next = head;
          if (head!= null) {
              head.previous = newNode;
          }
          head = newNode;
          if (tail == null) {
              tail= newNode;
          }
      } else {
          Node<E> nextNode = getNode(index);
          Node<E> prevNode = nextNode.previous;
          newNode.next = nextNode;
          newNode.previous = prevNode;
          prevNode.next = newNode;
          nextNode.previous = newNode;
      }
      size++;
    }



    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
    public String toStringReverse() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = tail;

        while (current != null) {
            sb.append(current.value);
            if (current.previous != null) {
                sb.append(" <-> ");
            }
            current = current.previous;
        }
        sb.append("]");
        return sb.toString();
    }
    public boolean isEmpty() {

        return this.head == null;
    }
    // DoublyLinkedList.java içine eklenecek metot

    public E getFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }

        return this.get(0);
    }
}
