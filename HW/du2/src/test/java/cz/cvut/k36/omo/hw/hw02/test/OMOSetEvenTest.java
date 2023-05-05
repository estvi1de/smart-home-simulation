package cz.cvut.k36.omo.hw.hw02.test;

import cz.cvut.k36.omo.hw.hw02.OMOSet;
import cz.cvut.k36.omo.hw.hw02.OMOSetEven;
import org.junit.Test;

import static org.junit.Assert.*;

public class OMOSetEvenTest {
    @Test
    public void contains() throws Exception {
        OMOSet set1 = new OMOSet();
        OMOSetEven intersection = new OMOSetEven(set1);

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        assertFalse(intersection.contains(1));
        assertTrue(intersection.contains(2));
        assertFalse(intersection.contains(3));
        assertTrue(intersection.contains(4));
    }
}