package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.parts.Room;

public class Computer extends Device implements FreeObject {
    private Boolean freeStatus = true;

    public Computer(String name, Room room, double periodicalElectricityConsumption) {
        super(false, name, room, periodicalElectricityConsumption);
    }

    public Boolean getFreeStatus() {
        return freeStatus;
    }

    public void setFreeStatus(Boolean status) {
        this.freeStatus = status;
    }
}