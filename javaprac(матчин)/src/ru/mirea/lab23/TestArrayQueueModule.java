package ru.mirea.lab23;

import static org.junit.Assert.*;
import org.junit.*;

public class TestArrayQueueModule {

    @Before
    public void setUp() {
        ArrayQueueModule.clear();
    }

    @Test
    public void testEnqueueAndSize() {
        for (int i = 0; i < 5; i++) {
            ArrayQueueModule.enqueue(i);
        }
        assertEquals(5, ArrayQueueModule.size());
    }

    @Test
    public void testDequeue() {
        ArrayQueueModule.enqueue(42);
        int result = ArrayQueueModule.dequeue();
        assertEquals(42, result);
        assertTrue(ArrayQueueModule.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeueOnEmptyQueue() {
        ArrayQueueModule.dequeue();
    }

    @Test
    public void testElement() {
        ArrayQueueModule.enqueue(42);
        int result = ArrayQueueModule.element();
        assertEquals(42, result);
        assertEquals(1, ArrayQueueModule.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testElementOnEmptyQueue() {
        ArrayQueueModule.element();
    }

    @Test
    public void testClear() {
        for (int i = 0; i < 5; i++) {
            ArrayQueueModule.enqueue(i);
        }
        ArrayQueueModule.clear();
        assertTrue(ArrayQueueModule.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(ArrayQueueModule.isEmpty());
        ArrayQueueModule.enqueue(42);
        assertFalse(ArrayQueueModule.isEmpty());
    }
}

