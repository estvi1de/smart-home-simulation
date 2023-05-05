package cz.cvut.k36.omo.hw.hw02;

public class OMOSetIntersection implements OMOSetView {

    OMOSetView setA;
    OMOSetView setB;

    public OMOSetIntersection(OMOSetView setA, OMOSetView setB) {
        this.setA = setA;
        this.setB = setB;
    }

    public OMOSetView getSetA() {
        return setA;
    }

    public void setSetA(OMOSetView setA) {
        this.setA = setA;
    }

    public OMOSetView getSetB() {
        return setB;
    }

    public void setSetB(OMOSetView setB) {
        this.setB = setB;
    }

    @Override
    public boolean contains(int element) {
        return setA.contains(element) && setB.contains(element);
    }

    @Override
    public int[] toArray() {
        return this.copy().toArray();
    }

    @Override
    public OMOSetView copy() {
        int[] arrB = setB.toArray();
        OMOSet set = new OMOSet();
        for (int i = 0; i < arrB.length; i++) {
            if (setA.contains(arrB[i])) {
                set.add(arrB[i]);
            }
        }
        return set;
    }
}