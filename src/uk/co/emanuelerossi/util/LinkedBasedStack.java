package uk.co.emanuelerossi.util;

import java.util.*;

/**
 * Created by ema on 30/03/16.
 */
public class LinkedBasedStack<T> implements Stack<T> {
    private Node top;
    private int elementsNumber;

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.value;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T result = top.value;
        top = top.next;
        elementsNumber--;

        return result;
    }

    @Override
    public void push(T item) {
        Node newTop = new Node(item, top);
        top = newTop;

        elementsNumber++;
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
