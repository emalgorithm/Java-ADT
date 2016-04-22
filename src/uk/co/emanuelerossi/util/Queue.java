package uk.co.emanuelerossi.util;

/**
 * Created by ema on 30/03/16.
 */
public interface Queue<T> {
    boolean isEmpty();

    T element();

    void add(T item);

    T remove();

    int size();
}
