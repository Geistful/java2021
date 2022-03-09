package com.mivaschenko.secondproblem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {
    private DoublyLinkedList<Integer> nonEmptyList;
    private DoublyLinkedList<Integer> emptyList;
    private int listSize;

    @BeforeEach
    public void init() {
        nonEmptyList = new DoublyLinkedList<>();
        emptyList = new DoublyLinkedList<>();
        listSize = 10;
        for (int i = 0; i < listSize; i++) {
            nonEmptyList.add(i * i);
        }
    }

    @Test
    public void sizeTest() {
        assertEquals(nonEmptyList.size(), listSize);
        assertEquals(emptyList.size(), 0);
    }

    @Test
    public void isEmptyTest() {
        assertTrue(emptyList.isEmpty());
        assertFalse(nonEmptyList.isEmpty());
    }

    @Test
    public void containsTest() {
        assertFalse(nonEmptyList.contains(3));
        assertTrue(nonEmptyList.contains(25));
        assertFalse(emptyList.contains(1));
    }

    @Test
    public void addTest() {
        assertTrue(nonEmptyList.add(-1));
        assertTrue(nonEmptyList.add(5));
    }

    @Test
    public void addAtIndexTest() {
        DoublyLinkedList<Integer> testList = new DoublyLinkedList<>();
        testList.add(0, 0);
        assertEquals(testList.last.item, 0);
        testList.add(0, 0);
        assertEquals(testList.first.item, 0);
        try {
            nonEmptyList.add(-1, 2);
        }
        catch (Exception e) {
            fail(e);
        }
        try {
            nonEmptyList.add(100,2);
        }
        catch (Exception e) {
            fail(e);
        }
    }

    @Test
    public void removeTest() {
        try {
            nonEmptyList.remove(-1);
        }
        catch (Exception e) {
            fail(e);
        }
        try {
            nonEmptyList.remove(100);
        }
        catch (Exception e) {
            fail("Invalid Index!" + e);
        }
        assertEquals(nonEmptyList.remove(1), 1);
        try {
            emptyList.remove(0);
        }
        catch (Exception e) {
            fail("Invalid Index!" + e);
        }
    }

    @Test
    public void iteratorTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.iterator());
    }

    @Test
    public void removeObjectTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.remove((Integer)1));
    }

    @Test
    public void addAllTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.addAll(emptyList));
    }

    @Test
    public void addAllAtIndexTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.addAll(5, emptyList));
    }

    @Test
    public void clearTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.clear());
    }

    @Test
    public void setTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.set(3, 2));
    }

    @Test
    public void indexOfTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.indexOf(1));
    }

    @Test
    public void lastIndexOfTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.lastIndexOf(1));
    }

    @Test
    public void listIteratorTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.listIterator());
    }

    @Test
    public void listIteratorAtIndexTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.listIterator());
    }

    @Test
    public void containsAllTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.containsAll(emptyList));
    }

    @Test
    public void removeAllTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.removeAll(emptyList));
    }

    @Test
    public void retainAllTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyList.retainAll(emptyList));
    }
}
