package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CutieQueueInterfaceTest {

    private CutieQueue<Cutie> cutieQueue;
    private Cutie puppy1;
    private Cutie puppy2;

    @BeforeEach
    void setUp() {
        cutieQueue = new CutieQueue<>(2);
        puppy1 = new Puppy("Golden Retriever", 10);
        puppy2 = new Puppy("Beagle", 9);
    }

    @Test
    void testEnqueueAndSizeWithInterface() {
        cutieQueue.enqueue(puppy1);
        assertEquals(1, cutieQueue.size(), "Queue size should be 1 after adding a Cutie."); //

        cutieQueue.enqueue(puppy2);
        assertEquals(2, cutieQueue.size(), "Queue size should be 2 after adding another Cutie."); //
    }

    @Test
    void testFullStatusWithInterface() {
        cutieQueue.enqueue(puppy1);
        cutieQueue.enqueue(puppy2);

        assertTrue(cutieQueue.full(), "Queue should return true for full() when at max_size."); //
    }

    @Test
    void testDequeueWithInterface() {
        cutieQueue.enqueue(puppy1);
        cutieQueue.enqueue(puppy2);

        cutieQueue.dequeue();


        assertEquals(1, cutieQueue.size(), "Size should be 1 after one dequeue."); //
    }

    @Test
    void testObjectAttributesAfterQueueing() {
        cutieQueue.enqueue(puppy1);

        assertEquals("A very cute Golden Retriever", puppy1.description()); //
        assertEquals(10, puppy1.cutenessRating()); //
    }

    @Test
    void testFIFOOrdering() {
        CutieQueue<Cutie> cutieQueue = new CutieQueue<>(5);

        Cutie firstIn = new Puppy("First Puppy", 10);
        Cutie secondIn = new Puppy("Second Puppy", 9);
        Cutie thirdIn = new Puppy("Third Puppy", 8);


        cutieQueue.enqueue(firstIn);
        cutieQueue.enqueue(secondIn);
        cutieQueue.enqueue(thirdIn);


        assertEquals(firstIn, cutieQueue.get(0), "The first item enqueued should be at the head.");
        assertEquals(3, cutieQueue.size());

        cutieQueue.dequeue();


        assertEquals(2, cutieQueue.size(), "Size should be 2 after one dequeue.");
        assertEquals(secondIn, cutieQueue.get(0), "After dequeue, the second item added should now be at the head.");


        cutieQueue.dequeue();

        assertEquals(1, cutieQueue.size());
        assertEquals(thirdIn, cutieQueue.get(0), "After two dequeues, the third item added should be at the head.");
    }

    @Test
    void testEnqueueOrderIntegrity() {
        CutieQueue<Cutie> cutieQueue = new CutieQueue<>(2);

        Cutie p1 = new Puppy("P1", 10);
        Cutie p2 = new Puppy("P2", 10);

        cutieQueue.enqueue(p1);
        cutieQueue.enqueue(p2);


        assertEquals(p1, cutieQueue.get(0));
        assertEquals(p2, cutieQueue.get(1));
    }
}