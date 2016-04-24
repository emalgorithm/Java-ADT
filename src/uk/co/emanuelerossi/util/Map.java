package uk.co.emanuelerossi.util;

/**
 * Created by ema on 22/04/16.
 */
public interface Map<K extends Comparable, V> {
    void add(K key, V value);

    void delete(K key);

    boolean contains(K key);

    V get(K key);
}
