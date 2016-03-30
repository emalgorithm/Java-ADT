package uk.co.emanuelerossi.util;

import com.sun.source.tree.AssertTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ema on 30/03/16.
 */
public abstract class QueueTest {
    protected Queue<Integer> queue;

    @Before
    public abstract void setUp() throws Exception;

    @After
    public abstract void tearDown() throws Exception;

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue("isEmpty with empty queue has failed", queue.isEmpty());

        queue.add(131);
        assertFalse("isEmpty with non-empty queue has failed", queue.isEmpty());
    }

    @Test
    public void testGetFront() throws Exception {
        Integer item = 34;
        queue.add(item);
        assertEquals("getFront has failed with non-empty queue", item, queue.getFront());
    }

    @Test(expected = EmptyQueueException.class)
    public void testGetFrontOnEmptyQueue() throws Exception {
        queue.getFront();
    }

    @Test
    public void testAdd() throws Exception {
        queue.add(10);
        assertEquals(1, queue.size());
    }

    @Test
    public void testDequeue() throws Exception {
        Integer firstItem = 12;
        Integer secondItem = 34;
        queue.add(firstItem);
        queue.add(secondItem);
        assertEquals("peek has failed with non-empty queue", firstItem, queue.dequeue());
        assertEquals("peek has failed with non-empty queue", secondItem, queue.dequeue());
    }

    @Test(expected = EmptyQueueException.class)
    public void testDequeueOnEmptyQueue() throws Exception {
        queue.dequeue();
    }
}