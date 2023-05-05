package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.parts.Room;

public class Light extends Device {
    public Light(String name, Room room) {
        super(true, name, room, 1);
        this.enableStatus = true;
    }
}