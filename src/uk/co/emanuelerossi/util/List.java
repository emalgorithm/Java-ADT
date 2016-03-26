package uk.co.emanuelerossi.util;

import java.util.Iterator;

/**
 * Created by ema on 16/03/16.
 */
public interface List<T> {
    int size();

    boolean isEmpty();

    void add(T elem, int pos);

    void remove(int pos);

    T get(int pos);

    boolean contains(T elem);

    void clear();

    Iterator<T> iterator();


}
