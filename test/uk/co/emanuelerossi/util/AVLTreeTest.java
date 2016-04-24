package uk.co.emanuelerossi.util;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by ema on 22/04/16.
 */
public class AVLTreeTest extends MapTest {

    @Before
    public void setUp() throws Exception {
        tree = new AVLTree<>();
    }

    @After
    public void tearDown() throws Exception {
        tree = null;
    }
}