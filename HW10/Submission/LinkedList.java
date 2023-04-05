import java.util.NoSuchElementException;

public class LinkedList <T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            head = new Node<T>(data, head);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(new Node<T>(data, current.getNext()));
        }
        size++;
    }

    public T removeFromIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index not valid.");
        }
        T data;
        if (index == 0) {
            data = head.getData();
            head = head.getNext();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            data = current.getNext().getData();
            current.setNext(current.getNext().getNext());
        }
        size--;
        return data;
    }

    public void clear() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            head = null;
            size = 0;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T[] toArrayList() {
        T[] array = (T[]) new Object[size];
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.getData();
            current = current.getNext();
        }
        return array;
    }
}
