//I worked on the homework assignment alone, using only course materials.
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * This class represents a linked list.
 * @param <T> type of data
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public class LinkedList<T> {
    private Node<T> head;
    private int size;

    /**
     * Constructor for the linked list.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds a node to the end of the linked list.
     * @param data data to be added
     * @param index index of the node to be added
     */
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

    /**
     * Adds a node to the end of the linked list.
     * @param index index of the node to be added
     * @return data of the node to be removed
     */
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

    /**
     * Removes all nodes from the linked list.
     * @throws NoSuchElementException if the list is empty
     */
    public void clear() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            head = null;
            size = 0;
        }
    }

    /**
     * Returns the data of the node at the given index.
     * @param index index of the node
     * @return data of the node
     */
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

    /**
     * Returns if the list is empty.
     * @return true if the list is empty, false otherwise
    */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an ArrayList representation of the linked list.
     * @return ArrayList representation of the linked list
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<T>();
        Node<T> current = head;
        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }

    /**
     * Returns a fizzbuzz linked list.
     * @return fizzbuzz linked list
     */
    public LinkedList<String> fizzBuzzLinkedList() {
        LinkedList<String> fizzList = new LinkedList<String>();
        for (int pos = 1; pos <= this.size; pos++) {
            if (pos % 3 == 0 && pos % 5 != 0) {
                fizzList.addAtIndex("Fizz", pos - 1);
            } else if (pos % 3 != 0 && pos % 5 == 0) {
                fizzList.addAtIndex("Buzz", pos - 1);
            } else if (pos % 3 == 0 && pos % 5 == 0) {
                fizzList.addAtIndex("FizzBuzz", pos - 1);
            } else {
                fizzList.addAtIndex(pos + ": " + this.get(pos - 1), pos - 1);
            }
        }
        return fizzList;
    }
}

