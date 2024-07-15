package ru.mirea.dashish21;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestArrayQueue {

    private ArrayQueue queue;

    @Before
    public void setUp() {
        queue = new ArrayQueue();
    }

    @Test
    public void testEnqueueAndSize() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        assertEquals(5, queue.size());
    }

    @Test
    public void testDequeue() {
        queue.enqueue(42);
        int result = queue.dequeue();
        assertEquals(42, result);
        assertTrue(queue.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeueOnEmptyQueue() {
        queue.dequeue();
    }

    @Test
    public void testElement() {
        queue.enqueue(42);
        int result = queue.element();
        assertEquals(42, result);
        assertEquals(1, queue.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testElementOnEmptyQueue() {
        queue.element();
    }

    @Test
    public void testClear() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(42);
        assertFalse(queue.isEmpty());
    }
}

