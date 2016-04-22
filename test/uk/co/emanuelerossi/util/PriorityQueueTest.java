package uk.co.emanuelerossi.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by ema on 01/04/16.
 */
public class PriorityQueueTest {
    PriorityQueue<Integer> queue;

    @Test
    public void testElement() throws Exception {
        Integer[] elems = {32, 43, 22, 13, 5, 34, 6};
        Integer[] elems2 = {32, 43, 22, 13, 5, 34, 6};

        queue = new PriorityQueue<>(elems);

        Arrays.sort(elems2);

        for (int i = 0; i < elems2.length; i++) {
            assertEquals(elems2[i], queue.element());
            queue.remove();
        }
    }

    @Test
    public void testRemove() throws Exception {
        Integer[] elems = {32, 43, 22, 13, 5, 34, 6};
        queue = new PriorityQueue<>(elems);

        Arrays.sort(elems);

        for (int i = 0; i < elems.length; i++) {
            assertEquals(elems[i], queue.remove());
        }
    }

}