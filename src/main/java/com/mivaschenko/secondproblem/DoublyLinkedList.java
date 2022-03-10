package com.mivaschenko.secondproblem;

import java.io.IOException;
import java.util.*;
import java.util.function.UnaryOperator;

public class DoublyLinkedList<E> implements List<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public DoublyLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object elem) {
        if (first == null || elem==null) {
            return false;
        }
        Node<E> iterator = first;
        while (iterator.next != null) {
            iterator = iterator.next;
            if (iterator.item == elem) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E elem) {
        Node<E> newNode = new Node<>(null, elem, null);
        if (size == 0) {
            first = newNode;
            last = newNode;
            first.next = last;
            last.prev = first;
        } else if (size == 1) {
            last = newNode;
            last.prev = first;
            first.next = last;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort(Comparator c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        int pointer = 0;
        if (index > size || index < 0)
            try {
                throw new IOException("Invalid Index!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        else if (index == size) {
            return last.item;
        }
        else if (index == 0) {
            return first.item;
        }
        else {
            pointer++;
            Node<E> iterator = first;
            while (iterator.next != null) {
                iterator = iterator.next;
                if (pointer == index) {
                    return iterator.item;
                }
                pointer++;
            }
        }
        return null;
    }

    @Override
    public E set(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, E element) {
        int pointer = 0;
        Node<E> newNode = new Node<>(null, element, null);
        if (index > size || index < 0)
            try {
                throw new IOException("Invalid Index!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        else if (index == size) {
            add(element);
            size++;
        }
        else if (index == 0) {
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
            size++;
        }
        else {
            pointer++;
            Node<E> iterator = first;
            while (iterator.next != null) {
                iterator = iterator.next;
                if (pointer == index) {
                    iterator.prev.next = newNode;
                    newNode.prev = iterator.prev;
                    iterator.prev = newNode;
                    newNode.next = iterator;
                    size++;
                    return;
                }
                pointer++;
            }
        }
    }

    @Override
    public E remove(int index) {
        E removedElement;
        int pointer = 0;
        if (index >= size || index < 0) {
            try {
                throw new IOException("Invalid Index!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (index == size-1) {
            removedElement = last.item;
            last.prev.next = null;
            last = last.prev;
            size--;
            return removedElement;
        }
        else if (index == 0) {
            removedElement = first.item;
            first.next.prev = null;
            first = first.next;
            size--;
            return removedElement;
        }
        else {
            pointer++;
            Node<E> iterator = first;
            while (iterator.next != null) {
                iterator = iterator.next;
                if (pointer == index) {
                    removedElement = iterator.item;
                    iterator.next.prev = iterator.prev;
                    iterator.prev.next = iterator.next;
                    size--;
                    return removedElement;
                }
                pointer++;
            }
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<E> spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
}
