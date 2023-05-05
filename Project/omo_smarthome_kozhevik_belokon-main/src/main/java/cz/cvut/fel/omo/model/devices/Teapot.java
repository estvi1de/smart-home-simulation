package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.parts.Room;

public class Teapot extends Device {
    public Teapot(String name, Room room, double periodicalElectricityConsumption) {
        super(true, name, room, periodicalElectricityConsumption);
    }
}