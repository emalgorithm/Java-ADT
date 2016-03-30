package uk.co.emanuelerossi.util;

import org.junit.After;
import org.junit.Before;

/**
 * Created by ema on 30/03/16.
 */
public class ArrayBasedQueueTest extends QueueTest {

    @Before
    @Override
    public void setUp() throws Exception {
        queue = new ArrayBasedQueue<>();
    }

    @After
    @Override
    public void tearDown() throws Exception {
        queue = null;
    }
}