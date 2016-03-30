package uk.co.emanuelerossi.util;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by ema on 30/03/16.
 */
public class LinkedBasedQueueTest extends QueueTest {

    @Before
    @Override
    public void setUp() throws Exception {
        queue = new LinkedBasedQueue<>();
    }

    @After
    @Override
    public void tearDown() throws Exception {
        queue = null;
    }
}