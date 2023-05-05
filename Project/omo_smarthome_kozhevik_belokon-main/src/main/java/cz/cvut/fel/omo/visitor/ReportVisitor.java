package cz.cvut.fel.omo.visitor;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.parts.*;
import cz.cvut.fel.omo.model.transport.Transport;
import cz.cvut.fel.omo.model.users.Person;

public class ReportVisitor implements CustomVisitor {
    @Override
    public void visitRoom(Room x) {
        if (x instanceof Outdoor) {
            System.out.println("This is outdoor, capacity - " + x.getCapacity() + " (standard), square - " + x.getSquare() + ", level - " + x.getLevel().getNumber());
        } else if (x instanceof Garage) {
            System.out.println("This is garage, capacity - " + x.getCapacity() + ", square - " + x.getSquare() + ", level - " + x.getLevel().getNumber());
        } else {
            System.out.println("This is room - " + x.getName() + ", capacity - " + x.getCapacity() + ", square - " + x.getSquare() + ", level - " + x.getLevel().getNumber());
        }
    }

    @Override
    public void visitLevel(Level x) {
        System.out.println("This is level - " + x.getNumber());
    }

    @Override
    public void visitHouse(House x) {
        System.out.println("This is House, address - " + x.getAddress() + ", the owner - " + x.getOwner().getName() + ", username - " + x.getOwner().getUsername());
    }

    @Override
    public void visitDevice(Device x) {
        System.out.println("This is device (" + x.getClass().getSimpleName() + ") - " + x.getTitle());
    }

    @Override
    public void visitTransport(Transport x) {
        System.out.println("This is transport - " + x.getClass().getSimpleName());
    }

    @Override
    public void visitPerson(Person x) {
        System.out.println("This is person - " + x.getName() + ", age - " + x.getAge());
    }
}