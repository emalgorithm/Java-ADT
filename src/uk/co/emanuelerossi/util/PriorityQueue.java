package uk.co.emanuelerossi.util;

/**
 * Created by ema on 01/04/16.
 */
public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {
    //The array starts storing objects from index 1
    private T[] heap;
    private int elementsNumber;
    public static int DEFAULT_SIZE = 10;

    public PriorityQueue() {
        this(DEFAULT_SIZE);
    }

    public PriorityQueue(int size) {
        heap = (T[]) new Comparable[size];
    }

    public PriorityQueue(T[] elems) {
        heap = (T[]) new Comparable[elems.length + 1];
        System.arraycopy(elems, 0, heap, 1, elems.length);
        elementsNumber = elems.length;
        buildHeap();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T element() {
        return heap[1];
    }

    @Override
    public void add(T item) {
        if (size() + 1 == heap.length) {
            expand();
        }

        heap[++elementsNumber] = item;

        int currentIndex = elementsNumber;

        while(parent(currentIndex) > 0 && heap[parent(currentIndex)].compareTo
                (heap[currentIndex]) > 0) {

            int pIndex = parent(currentIndex);
            T temp = heap[pIndex];
            heap[pIndex] = heap[currentIndex];
            heap[currentIndex] = temp;

            currentIndex = pIndex;
        }
    }

    private void expand() {
        T[] newHeap = (T[]) new Object[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        T result = heap[1];

        heap[1] = heap[elementsNumber];
        heapify(1);

        elementsNumber--;

        return result;
    }

    @Override
    public int size() {
        return elementsNumber;
    }

    private static int parent(int i) {
        return i >> 1;
    }

    private static int leftChild(int i) {
        return i << 1;
    }

    private static int rightChild(int i) {
        return (i << 1) + 1;
    }

    private void buildHeap() {
        for (int i = elementsNumber; i >= 1; i--) {
            heapify(i);
        }
    }

    private void heapify(int root) {
        int left = leftChild(root);
        int right = rightChild(root);
        int minIndex = root;

        if (left <= elementsNumber && heap[left].compareTo(heap[minIndex]) < 0) {
            minIndex = left;
        }

        if (right <= elementsNumber && heap[right].compareTo(heap[minIndex]) < 0) {
            minIndex = right;
        }

        if (minIndex != root) {
            T temp = heap[root];
            heap[root] = heap[minIndex];
            heap[minIndex] = temp;

            heapify(minIndex);
        }
    }
}
