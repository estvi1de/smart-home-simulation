package cz.cvut.k36.omo.hw.hw02.test;

import cz.cvut.k36.omo.hw.hw02.OMOSet;
import cz.cvut.k36.omo.hw.hw02.OMOSetComplement;
import org.junit.Test;

import static org.junit.Assert.*;

public class OMOSetComplementTest {
    @Test
    public void contains() throws Exception {
        OMOSet set1 = new OMOSet();
        OMOSet set2 = new OMOSet();
        OMOSetComplement complement = new OMOSetComplement(set1, set2);

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);

        assertTrue(complement.contains(1));
        assertFalse(complement.contains(2));
        assertFalse(complement.contains(3));
        assertFalse(complement.contains(4));
    }
}