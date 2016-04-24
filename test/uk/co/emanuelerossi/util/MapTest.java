package uk.co.emanuelerossi.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ema on 22/04/16.
 */
public abstract class MapTest {
    Map<Integer, String> tree;

    @Before
    public abstract void setUp() throws Exception;

    @After
    public abstract void tearDown() throws Exception;

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testContainsSmall() {
        containsCheck(new Integer[] { 1 });
    }

    @Test
    public void testContainsLarge() {
        containsCheck(new Integer[] { 1, 3, 5, 7, 9, 10, 8, 6, 4, 2, 0 });
    }

    @Test
    public void testContainsFalse() {
        Assert.assertFalse(tree.contains(9));
    }

    private void containsCheck(Integer[] keys) {
        for (Integer k : keys) {
            tree.add(k, k.toString());
        }

        for (Integer k : keys) {
            Assert.assertTrue(tree.contains(k));
        }
    }

    @Test
    public void testLookupSmall() {
        lookupCheck(new Integer[] { 1 });
    }

    @Test
    public void testLookupLarge() {
        lookupCheck(new Integer[] { 1, 3, 5, 7, 9, 10, 8, 6, 4, 2, 0 });
    }

    @Test
    public void testLookupFalse() {
        Assert.assertFalse(tree.contains(9));
    }

    private void lookupCheck(Integer[] keys) {
        for (Integer k : keys) {
            tree.add(k, k.toString());
        }

        for (Integer k : keys) {
            Assert.assertEquals(k.toString(), tree.get(k));
        }
    }

    @Test
    public void testDelete() throws Exception {
        Integer[] elems = new Integer[] { 1, 3, 5, 7, 9, 10, 8, 6, 4, 2, 0 };
        Integer[] elems2 = new Integer[] { 1, 3, 5, 9, 10, 6, 4, 2};
        Integer[] toRemove = new Integer[] {7, 8 , 0};

        for (Integer k : elems) {
            tree.add(k, k.toString());
        }

        for (Integer k : toRemove) {
            tree.delete(k);
        }

        for (Integer k : elems2) {
            assertTrue(tree.contains(k));
        }

        for (Integer k : toRemove) {
            assertFalse(tree.contains(k));
        }
    }
}