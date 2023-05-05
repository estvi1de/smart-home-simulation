package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.parts.Room;

public interface FreeObject {
    Boolean getFreeStatus();

    String getTitle();

    Room getRoom();

    void setFreeStatus(Boolean status);
}