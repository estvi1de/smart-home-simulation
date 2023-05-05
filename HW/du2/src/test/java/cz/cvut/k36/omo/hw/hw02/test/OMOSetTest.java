package cz.cvut.k36.omo.hw.hw02.test;

import cz.cvut.k36.omo.hw.hw02.OMOSet;
import cz.cvut.k36.omo.hw.hw02.OMOSetView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OMOSetTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void add() throws Exception {
        OMOSet set = new OMOSet();
        set.add(0);
        assertTrue(set.contains(0));
    }

    @Test
    public void remove() throws Exception {
        OMOSet set = new OMOSet();
        set.add(0);
        set.add(1);
        set.remove(0);
        assertFalse(set.contains(0));
        assertTrue(set.contains(1));
    }

    @Test
    public void contains() throws Exception {
        OMOSet set = new OMOSet();
        set.add(0);
        assertTrue(set.contains(0));
    }

    @Test
    public void toArray() throws Exception {
        OMOSet set = new OMOSet();
        set.add(0);
        set.add(1);
        set.add(2);
        int[] arr = set.toArray();
        assertArrayEquals(arr, new int[]{0, 1, 2});
    }

    @Test
    public void copy() throws Exception {
        OMOSet set1 = new OMOSet();
        set1.add(0);
        set1.add(1);
        set1.add(2);

        OMOSetView set2 = set1.copy();

        assertArrayEquals(set1.toArray(), set2.toArray());

        set1.add(3);

        assertFalse(Arrays.equals(set1.toArray(), set2.toArray()));
        assertFalse(set2.contains(3));

        set1.remove(1);
        assertTrue(set2.contains(1));
    }
}