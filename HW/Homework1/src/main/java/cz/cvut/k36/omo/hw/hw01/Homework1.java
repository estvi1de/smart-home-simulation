package cz.cvut.k36.omo.hw.hw01;

public class Homework1 {
    private int hpocet = 0;
    private static int ipocet = 0;

    public boolean f() {
        return true;
    }

    public static boolean g() {
        return false;
    }

    public int h() {
        this.hpocet++;
        return this.hpocet;
    }

    public static int i() {
        Homework1.ipocet++;
        return Homework1.ipocet;
    }
}