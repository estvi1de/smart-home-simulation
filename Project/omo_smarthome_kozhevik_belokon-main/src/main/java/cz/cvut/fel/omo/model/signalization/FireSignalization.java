package cz.cvut.fel.omo.model.signalization;

import cz.cvut.fel.omo.model.parts.House;

public class FireSignalization implements Signalization {
    private House house;

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void checkSmoke(int temperature) {
        if (temperature >= 70) {
            System.out.println("Call to fire service!");
            house.getGasLeakSignalization().allOff();
            house.getPowerOutagesSignalization().allOff();
        }
    }

    public void stabilize() {
        System.out.println("On all services");
        house.getPowerOutagesSignalization().allOn();
        house.getGasLeakSignalization().allOn();
    }
}