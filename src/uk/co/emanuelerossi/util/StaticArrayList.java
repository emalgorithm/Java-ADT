package uk.co.emanuelerossi.util;

/**
 * Created by ema on 16/03/16.
 */
public class StaticArrayList<T> implements List<T> {

    private int elementsNumber;
    private final int maxSize;
    private T[] elems;
    private static int DEFAULT_SIZE = 1000;

    public StaticArrayList(int maxSize) {
        this.elems = (T[]) (new Object[maxSize]);
        this.maxSize = maxSize;
    }

    public StaticArrayList() {
        this(DEFAULT_SIZE);
    }

    @Override
    public int size() {
        return elementsNumber;
    }

    @Override
    public boolean isEmpty() {
        return elementsNumber == 0;
    }

    @Override
    public void add(T elem, int pos) {
        if (pos < 0 || pos > elementsNumber) {
            throw new ListIndexOutOfBoundException("Position out of range");
        }

        if (elementsNumber == maxSize) {
            throw new ListException("List is full");
        }

        makeSpace(pos);
        elems[pos] = elem;
        elementsNumber++;
    }

    @Override
    public void remove(int pos) {
        if (pos < 0 || pos >= elementsNumber) {
            throw new ListIndexOutOfBoundException("Position out of range");
        }

        for (int i = pos; i < elementsNumber; i++) {
            elems[i] = elems[i + 1];
        }

        elementsNumber--;
    }

    @Override
    public T get(int pos) {
        if (pos < 0 || pos >= elementsNumber) {
            throw new ListIndexOutOfBoundException("Position out of range");
        }

        return elems[pos];
    }

    @Override
    public void clear() {
        //Clear array to allow garbage collection
        for (int i = 0; i < elementsNumber; i++) {
            elems[i] = null;
        }

        elementsNumber = 0;
    }

    private void makeSpace(int pos) {
        for (int i = elementsNumber; i > pos; i--) {
            elems[i + 1] = elems[i];
        }
    }
}
