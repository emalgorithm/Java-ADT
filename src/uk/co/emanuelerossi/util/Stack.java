package uk.co.emanuelerossi.util;

/**
 * Created by ema on 30/03/16.
 */
public interface Stack<T> {
    boolean isEmpty();

    T peek();

    T pop();

    void push(T item);

    int size();
}
