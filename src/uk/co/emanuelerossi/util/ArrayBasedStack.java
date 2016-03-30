package uk.co.emanuelerossi.util;

import java.util.*;

/**
 * Created by ema on 30/03/16.
 */
public class ArrayBasedStack<T> implements Stack<T> {
    private int elementsNumber;
    private T[] elems;

    public ArrayBasedStack() {
        int initialSize = 10;
        elems = (T[]) new Object[initialSize];
    }

    @Override
    public boolean isEmpty() {
        return elementsNumber == 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elems[elementsNumber - 1];
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elems[--elementsNumber];
    }

    @Override
    public void push(T item) {
        if (elementsNumber == elems.length) {
            expandElems();
        }

        elems[elementsNumber++] = item;
    }

    @Override
    public int size() {
        return elementsNumber;
    }

    private void expandElems() {
        T[] newElems = (T[]) new Object[elems.length * 2];
        System.arraycopy(elems, 0, newElems, 0, elems.length);
        elems = newElems;
    }
}
