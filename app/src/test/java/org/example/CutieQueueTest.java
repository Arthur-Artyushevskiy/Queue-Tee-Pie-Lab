package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class CutieQueueTest {

    private CutieQueue<String> stringQueue;
    private final int MAX_SIZE = 3;

    @BeforeEach
    void setUp() {

        stringQueue = new CutieQueue<>(MAX_SIZE);
    }

    @Test
    void testInitialSizeIsZero() {
        assertEquals(0, stringQueue.size(), "Initial queue size should be 0.");
    }

    @Test
    void testEnqueueIncreasesSize() {
        stringQueue.enqueue("Puppy");
        assertEquals(1, stringQueue.size(), "Size should be 1 after one enqueue.");

        stringQueue.enqueue("Kitten");
        assertEquals(2, stringQueue.size(), "Size should be 2 after two enqueues.");
    }

    @Test
    void testFullReturnsTrueWhenAtCapacity() {
        stringQueue.enqueue("Item 1");
        stringQueue.enqueue("Item 2");
        stringQueue.enqueue("Item 3");

        assertTrue(stringQueue.full(), "Queue should be full when size equals max_size.");
        assertEquals(MAX_SIZE, stringQueue.size());
    }

    @Test
    void testEnqueueWhenFullDoesNotAdd() {
        stringQueue.enqueue("Item 1");
        stringQueue.enqueue("Item 2");
        stringQueue.enqueue("Item 3");


        stringQueue.enqueue("Item 4");

        assertEquals(MAX_SIZE, stringQueue.size(), "Size should not exceed max_size.");
    }

    @Test
    void testDequeueDecreasesSize() {
        stringQueue.enqueue("Puppy");
        stringQueue.enqueue("Kitten");

        stringQueue.dequeue();

        assertEquals(1, stringQueue.size(), "Size should decrease after dequeue.");
    }

    @Test
    void testConstructorWithExistingList() {
        ArrayList<Integer> existingList = new ArrayList<>();
        existingList.add(1);
        existingList.add(2);

        CutieQueue<Integer> intQueue = new CutieQueue<>(existingList, 5);

        assertEquals(2, intQueue.size(), "Queue should reflect the size of the passed ArrayList.");
        assertFalse(intQueue.full(), "Queue should not be full.");
    }
}