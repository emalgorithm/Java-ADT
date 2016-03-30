package uk.co.emanuelerossi.util;

/**
 * Created by ema on 30/03/16.
 */
public class ArrayBasedQueue<T> implements Queue<T> {
    private int elementsNumber;
    private int frontIndex;
    private int lastInsertedIndex;
    private T[] elems;
    public static int DEFAULT_SIZE = 1000;

    public ArrayBasedQueue(int size) {
        elems = (T[]) new Object[size];
        lastInsertedIndex = -1;
    }

    public ArrayBasedQueue() {
        this(DEFAULT_SIZE);
    }

    @Override
    public boolean isEmpty() {
        return elementsNumber == 0;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return elems[frontIndex];
    }

    private int adjust(int pos) {
        return (pos + elems.length) % elems.length;
    }

    @Override
    public void add(T item) {
        if (elementsNumber == elems.length) {
            throw new FullQueueException();
        }

        int index = adjust(lastInsertedIndex + 1);
        elems[index] = item;
        lastInsertedIndex = index;

        elementsNumber++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        T result = elems[frontIndex];
        frontIndex = adjust(frontIndex + 1);

        return result;
    }

    @Override
    public int size() {
        return elementsNumber;
    }
}
