package uk.co.emanuelerossi.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ema on 30/03/16.
 */
public abstract class StackTest {
    protected Stack<Integer> stack;

    @Before
    public abstract void setUp() throws Exception;

    @After
    public abstract void tearDown() throws Exception;

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue("isEmpty with empty stack has failed", stack.isEmpty());

        stack.push(10);
        assertFalse("isEmpty with non-empty stack has failed", stack.isEmpty());
    }

    @Test
    public void testPeek() throws Exception {
        Integer item = 34;
        stack.push(item);
        assertEquals("peek has failed with non-empty stack", item, stack.peek());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekOnEmptyStack() throws Exception {
        stack.peek();
    }

    @Test
    public void testPop() throws Exception {
        Integer firstItem = 12;
        Integer secondItem = 34;
        stack.push(firstItem);
        stack.push(secondItem);
        assertEquals("peek has failed with non-empty stack", secondItem, stack.pop());
        assertEquals("peek has failed with non-empty stack", firstItem, stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopOnEmptyStack() throws Exception {
        stack.pop();
    }

    @Test
    public void testPush() throws Exception {
        stack.push(10);
        assertEquals(1, stack.size());
    }
}