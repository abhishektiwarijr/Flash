package unordered_list;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnorderedList<E> implements List<E> {

    private int defaultCapacity = 10;
    private int size;
    private Object[] nodeElements;

    public UnorderedList() {
        nodeElements = new Object[defaultCapacity];
    }

    public UnorderedList(int capacity) {
        defaultCapacity = capacity;
        nodeElements = new Object[defaultCapacity];
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new ULIterator();
    }

    private class ULIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size();
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            if (hasNext()) {
                return (E) nodeElements[currentIndex++];
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    @Override
    public boolean isFull() {
        return size == defaultCapacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(E data) {
        ensureCapacity();
        nodeElements[size++] = data;
        return true;
    }

    private void ensureCapacity() {
        if (isFull()) {
            resize();
        }
    }

    private void resize() {
        defaultCapacity *= 2;
        nodeElements = Arrays.copyOf(nodeElements, defaultCapacity);
    }

    @Override
    public void remove(E data) {
        int indexToDelete = locate(data);

        if (indexToDelete != -1) {
            nodeElements[indexToDelete] = nodeElements[size() - 1];
            size--;
        }
    }

    @Override
    public boolean find(E data) {
        return (locate(data) >= 0);
    }

    private int locate(E data) {
        for (int i = 0; i < size(); i++) {
            if (data == nodeElements[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return defaultCapacity;
    }
}