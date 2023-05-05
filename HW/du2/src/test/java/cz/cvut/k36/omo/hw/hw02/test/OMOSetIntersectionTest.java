package cz.cvut.k36.omo.hw.hw02.test;

import cz.cvut.k36.omo.hw.hw02.OMOSet;
import cz.cvut.k36.omo.hw.hw02.OMOSetIntersection;
import org.junit.Test;

import static org.junit.Assert.*;

public class OMOSetIntersectionTest {
    @Test
    public void contains() throws Exception {
        OMOSet set1 = new OMOSet();
        OMOSet set2 = new OMOSet();
        OMOSetIntersection intersection = new OMOSetIntersection(set1, set2);

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);

        assertFalse(intersection.contains(1));
        assertTrue(intersection.contains(2));
        assertTrue(intersection.contains(3));
        assertFalse(intersection.contains(4));
    }
}