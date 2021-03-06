package uk.co.emanuelerossi.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by ema on 16/03/16.
 */
public abstract class ListTest {

    protected List<String> list;

    @Before
    public abstract void setUp() throws Exception;

    @After
    public abstract void tearDown() throws Exception;

    @Test
    public void testClear() {
        list.clear();
        assertTrue("clear() failed for Empty dictionary ", list.isEmpty());
    }

    @Test
    public void testClearWithContent() {
        list.add("Jennyanydots", 0);
        list.clear();
        assertTrue("clear() failed for non-empty dictionary ", list.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals("size() failed for isEmpty dictionary", 0, list.size());

        list.add("Skimbleshanks", 0);
        assertEquals("size() failed for single item dictionary", 1, list.size());

        list.clear();
        java.util.List<String> cats = Arrays.asList("Growltiger", "Rum Tum Tugger", "Jellicles");

        for (String cat : cats) {
            list.add(cat, 0);
        }

        assertEquals("size() failed for multiple cats", cats.size(), list.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue("isEmpty() failed for isEmpty dictionary", list.isEmpty());

        list.add("Tigger", 0);
        assertFalse("isEmpty() failed for dictionary with one element", list.isEmpty());
    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {
        list.add("Tiddles", 0);
        list.remove(0);
        assertEquals("remove() failed with single item dictionary", 0, list.size());


        java.util.List<String> cats = Arrays.asList("Gus", "Tiddles", "Skimbleshanks");

        for (int i = 0; i < cats.size(); i++) {
            list.add(cats.get(i), 0);
        }

        System.out.println(list);

        list.remove(1);

        assertEquals("remove() failed with multiple item dictionary", 2, list
                .size());

    }

    @Test(expected = ListIndexOutOfBoundException.class)
    public void testGetException() {
        list.get(0);
    }

    @Test(expected = ListIndexOutOfBoundException.class)
    public void testRemoveEmpty() {
        list.remove(0);
    }

    @Test
    public void testGet() throws Exception {
        list.add("Tiddles", 0);
        assertEquals("get() failed for one item dictionary", "Tiddles", list
                .get(0));

        list.clear();
        java.util.List<String> cats = Arrays.asList("Bustopher Jones", "Old Deuteronomy",
                "Mr. Mistoffelees", "Gus");

        for (int i = 0; i < cats.size(); i++) {
            list.add(cats.get(i), i);
        }

        assertEquals("get() failed for multiple item dictionary", "Mr. Mistoffelees", list
                .get(2));
    }

    @Test
    public void testListIteratorEmpty() {
        Iterator<String> it = list.iterator();
        assertFalse("Iterator: hasNext() failed with empty dictionary", it
                .hasNext());
    }

    @Test
    public void testListIteratorMany() {
        java.util.List<String> cats = Arrays.asList("practical", "dramatical",
                "pragmatical", "fanatical", "oratorical", "delphioracle",
                "skeptical", "dispeptical", "romantical", "pedantical",
                "critical", "parasitical", "allegorical", "metaphorical",
                "statistical", "mystical", "political", "hypocritical",
                "clerical", "hysterical", "cynical", "rabbinical");
        for (int i = 0; i < cats.size(); i++) {
            list.add(cats.get(i), i);
        }

        java.util.List<String> sortedCats = new ArrayList<String>(cats);

        Iterator<String> expected = sortedCats.iterator();
        Iterator<String> actual = list.iterator();

        while (expected.hasNext()) {
            assertTrue("Iterator hasNext() failed when expected", actual
                    .hasNext());

            String expectedCat = expected.next();
            String actualCat = actual.next();

            assertEquals("Iterator next() returned the wrong element",
                    expectedCat, actualCat);

        }
        assertFalse("Iterator hasNext() failed at the end of the dictionary",
                actual.hasNext());

    }
}