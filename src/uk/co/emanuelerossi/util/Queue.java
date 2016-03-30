package uk.co.emanuelerossi.util;

/**
 * Created by ema on 30/03/16.
 */
public interface Queue<T> {
    boolean isEmpty();

    T getFront();

    void add(T item);

    T dequeue();

    int size();
}
