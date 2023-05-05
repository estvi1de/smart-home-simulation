package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.parts.Room;

public class RobotVacuumCleaner extends Device {
    public RobotVacuumCleaner(String name, Room room, double periodicalElectricityConsumption) {
        super(true, name, room, periodicalElectricityConsumption);
    }
}