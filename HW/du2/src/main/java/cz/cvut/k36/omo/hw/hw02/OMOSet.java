package cz.cvut.k36.omo.hw.hw02;

import java.util.HashSet;
import java.util.Set;

public class OMOSet extends OMOSetBase implements OMOSetView {

    HashSet<Integer> hashSet = new HashSet<>();

    public Set<Integer> getHashSet() {
        return hashSet;
    }

    public void setHashSet(Set<Integer> hashSet) {
        this.hashSet = (HashSet<Integer>) hashSet;
    }

    @Override
    public boolean contains(int element) {
        return hashSet.contains(element);
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[hashSet.size()];
        int i = 0;
        for (Integer element : hashSet) {
            arr[i] = element;
            i++;
        }
        return arr;
    }

    @Override
    public OMOSetView copy() {
        OMOSet copy = new OMOSet();
        for (Integer elem : hashSet)
            copy.add(elem);
        return copy;
    }

    @Override
    public void add(int element) {
        hashSet.add(element);
    }

    @Override
    public void remove(int element) {
        hashSet.remove(element);
    }
}