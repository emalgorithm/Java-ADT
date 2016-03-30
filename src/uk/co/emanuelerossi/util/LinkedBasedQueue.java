package uk.co.emanuelerossi.util;

/**
 * Created by ema on 30/03/16.
 */
public class LinkedBasedQueue<T> implements Queue<T> {
    private Node front;
    private Node tail;
    private int elementsNumber;

    @Override
    public boolean isEmpty() {
        return elementsNumber == 0;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return front.value;
    }

    @Override
    public void add(T item) {
        Node newTail = new Node(item, tail);

        if (tail == null) {
            front = newTail;
        } else {
            tail.next = newTail;
        }

        tail = newTail;
        elementsNumber++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        Node result = front;

        if (front == tail) {
            tail = null;
        }

        front = front.next;
        elementsNumber--;

        return result.value;
    }

    @Override
    public int size() {
        return elementsNumber;
    }

    private class Node {
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this(value, null);
        }

        public Node() {
            this(null, null);
        }
    }
}
