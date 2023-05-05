package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.parts.Room;

public class Conditioner extends Device {
    public Conditioner(String name, Room room, double periodicalElectricityConsumption) {
        super(false, name, room, periodicalElectricityConsumption);
    }
}