package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.parts.Room;

public class TV extends Device {

    public TV(String name, Room room, double periodicalElectricityConsumption) {
        super(true, name, room, periodicalElectricityConsumption);
    }
}