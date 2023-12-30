package unordered_list;

import java.util.Iterator;

public interface List<E> {
    boolean isFull();

    boolean isEmpty();

    boolean add(E data);

    void remove(E data);

    boolean find(E data);

    int size();

    int capacity();

    Iterator<E> iterator();
}