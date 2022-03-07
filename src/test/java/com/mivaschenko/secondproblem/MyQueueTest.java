package com.mivaschenko.secondproblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {
    private MyQueue<Integer> nonEmptyQueue;
    private MyQueue<Integer> emptyQueue;

    @BeforeEach
    public void init() {
        nonEmptyQueue = new MyQueue<>();
        emptyQueue = new MyQueue<>();
        int queueSize = 10;
        for (int i = 0; i< queueSize; i++) {
            nonEmptyQueue.add(i*i);
        }
    }

    @Test
    public void pollTest() {
        assertEquals(0, nonEmptyQueue.poll());
    }

    @Test
    public void addTest() {
        assertTrue(nonEmptyQueue.add(63));
        assertTrue(emptyQueue.add(null));
    }

    @Test
    public void isEmptyTest() {
        assertTrue(emptyQueue.isEmpty());
        assertFalse(nonEmptyQueue.isEmpty());
    }

    @Test
    public void sizeTest() {
        assertEquals(nonEmptyQueue.size(), 10);
    }

    @Test
    public void containsTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyQueue.contains(2));
    }

    @Test
    public void iteratorTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyQueue.iterator());
    }

    @Test
    public void toArrayTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyQueue.toArray());
    }

    @Test
    public void removeTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyQueue.remove(2));
    }

    @Test
    public void addAllTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyQueue.addAll(emptyQueue));
    }

    @Test
    public void clearTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyQueue.clear());
    }

    @Test
    public void retainAllTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyQueue.retainAll(emptyQueue));
    }

    @Test
    public void removeAllTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyQueue.removeAll(emptyQueue));
    }

    @Test
    public void peekTest() {
        assertThrows(UnsupportedOperationException.class, () -> nonEmptyQueue.peek());
    }
}
