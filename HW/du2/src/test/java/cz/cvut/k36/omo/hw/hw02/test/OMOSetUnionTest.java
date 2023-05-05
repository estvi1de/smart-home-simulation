package cz.cvut.k36.omo.hw.hw02.test;

import cz.cvut.k36.omo.hw.hw02.OMOSet;
import cz.cvut.k36.omo.hw.hw02.OMOSetUnion;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Sample tests for OMO/2016L HW2 come without any warranty
 *
 * @author Pavel Krulec krulepav@fel.cvut.cz
 */
public class OMOSetUnionTest {
    @Test
    public void contains() throws Exception {
        OMOSet set1 = new OMOSet();
        OMOSet set2 = new OMOSet();
        OMOSetUnion union = new OMOSetUnion(set1, set2);

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);

        assertTrue(union.contains(1));
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertTrue(union.contains(4));
    }
}