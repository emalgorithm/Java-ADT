package uk.co.emanuelerossi.util;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by ema on 16/03/16.
 */
public class LinkedListTest extends ListTest {

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }
}