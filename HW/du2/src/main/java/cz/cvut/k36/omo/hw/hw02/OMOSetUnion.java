package cz.cvut.k36.omo.hw.hw02;

public class OMOSetUnion implements OMOSetView {

    OMOSetView setA;
    OMOSetView setB;

    public OMOSetUnion(OMOSetView setA, OMOSetView setB) {
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
        return setA.contains(element) || setB.contains(element);
    }

    @Override
    public int[] toArray() {
        return this.copy().toArray();
    }

    @Override
    public OMOSetView copy() {
        int[] arrA = setA.toArray();
        int[] arrB = setB.toArray();
        OMOSet set = new OMOSet();
        for (int i : arrA) {
            set.add(i);
        }
        for (int i : arrB) {
            if (!set.contains(i)) {
                set.add(i);
            }
        }
        return set;
    }
}