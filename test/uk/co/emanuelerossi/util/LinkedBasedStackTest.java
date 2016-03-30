package uk.co.emanuelerossi.util;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by ema on 30/03/16.
 */
public class LinkedBasedStackTest extends StackTest {

    @Before
    @Override
    public void setUp() throws Exception {
        stack = new LinkedBasedStack<>();
    }

    @After
    @Override
    public void tearDown() throws Exception {
        stack = null;
    }
}