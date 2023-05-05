package cz.cvut.fel.omo.visitor;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.parts.*;
import cz.cvut.fel.omo.model.transport.Transport;
import cz.cvut.fel.omo.model.users.Person;

public interface CustomVisitor {
    void visitRoom(Room x);

    void visitLevel(Level x);

    void visitHouse(House x);

    void visitDevice(Device x);

    void visitTransport(Transport x);

    void visitPerson(Person x);
}