package uk.co.emanuelerossi.util;

import java.util.Iterator;

/**
 * Created by ema on 16/03/16.
 */
public class LinkedList<T> implements List<T> {
    Node head;
    int elementsNumber;

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

        Node newNode = new Node(elem);

        if (pos == 0) {
            if (head != null) {
                head.setPrev(newNode);
            }

            newNode.setNext(head);
            head = newNode;
        } else {
            Node prev = getNode(pos - 1);
            Node next = prev.getNext();
            prev.setNext(newNode);
            newNode.setNext(next);
            newNode.setPrev(prev);

            if (next != null) {
                next.setPrev(newNode);
            }
        }

        elementsNumber++;
    }

    @Override
    public void remove(int pos) {
        if (pos < 0 || pos >= elementsNumber) {
            throw new ListIndexOutOfBoundException("Position out of range");
        }

        Node node = getNode(pos);
        Node next = node.getNext();
        Node prev = node.getPrev();

        if (pos == 0) {
            head = next;
            if (elementsNumber > 1) {
                next.setPrev(null);
            }
        } else {
            prev.setNext(next);

            if (next != null) {
                next.setPrev(prev);
            }
        }

        elementsNumber--;
    }

    @Override
    public T get(int pos) {
        return getNode(pos).getValue();
    }

    @Override
    public boolean contains(T elem) {
        Node node = head;

        while (node != null) {
            if (node.getValue() == elem) {
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    @Override
    public void clear() {
        head = null;
        elementsNumber = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        int pos;
        int expectedModificationNum;
        Node lastRemovedNode;

        public LinkedListIterator() {
            pos = 0;
            expectedModificationNum = 0;
            lastRemovedNode = null;
        }

        @Override
        public boolean hasNext() {
            return pos < elementsNumber;
        }

        @Override
        public T next() {
            //TODO nextNode is null --> exception
            //TODO change from N^2 to N
            return getNode(pos++).getValue();
        }

        @Override
        public void remove() {
            //TODO introduce remove testing
            if (pos == 0) {
                throw new IllegalStateException();
            }

            LinkedList.this.remove(pos--);
        }
    }

    private Node getNode(int pos) {
        if (pos < 0 || pos >= elementsNumber) {
            throw new ListIndexOutOfBoundException("Position out of range");
        }

        Node node = head;

        while (pos-- > 0) {
            node = node.getNext();
        }

        return node;
    }

    private class Node {
        private T value;
        private Node next;
        private Node prev;

        private Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        private Node(T value) {
            this(value, null, null);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
