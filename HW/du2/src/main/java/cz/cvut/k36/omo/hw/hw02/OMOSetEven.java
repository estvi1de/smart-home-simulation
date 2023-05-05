package cz.cvut.k36.omo.hw.hw02;

public class OMOSetEven implements OMOSetView {

    OMOSetView setA;

    public OMOSetEven(OMOSetView setA) {
        this.setA = setA;
    }

    public OMOSetView getSetA() {
        return setA;
    }

    public void setSetA(OMOSetView setA) {
        this.setA = setA;
    }

    @Override
    public boolean contains(int element) {
        return setA.contains(element) && (element % 2 == 0);
    }

    @Override
    public int[] toArray() {
        return this.copy().toArray();
    }

    @Override
    public OMOSetView copy() {
        int[] arrA = setA.toArray();
        OMOSet set = new OMOSet();
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] % 2 == 0) {
                set.add(arrA[i]);
            }
        }
        return set;
    }
}