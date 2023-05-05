package cz.cvut.fel.omo.model.parts;

import cz.cvut.fel.omo.model.transport.Transport;
import cz.cvut.fel.omo.visitor.CustomVisitor;
import cz.cvut.fel.omo.visitor.Visit;

import java.util.List;

public class Garage extends Room implements Visit {

    public Garage(Integer capacity, Double square, Level level, String name) {
        super(capacity, square, level, name);
    }

    List<Transport> transport;

    public List<Transport> getTransport() {
        return transport;
    }

    public void setTransport(List<Transport> transport) {
        this.transport = transport;
    }

    @Override
    public Integer getFreePlace() {
        int currentCapacity = 0;
        if (peopleInRoom != null && petsInRoom != null) {
            currentCapacity = peopleInRoom.size() + petsInRoom.size();
        } else if (peopleInRoom != null) {
            currentCapacity = peopleInRoom.size();
        } else if (petsInRoom != null) {
            currentCapacity = petsInRoom.size();
        }
        for (Transport currentTransport : transport) {
            currentCapacity += currentTransport.getVolume();
        }
        if (capacity > currentCapacity)
            return capacity - currentCapacity;
        return 0;
    }

    @Override
    public void accept(CustomVisitor v) {
        v.visitRoom(this);
        if (transport != null) {
            for (Transport currentTransport :
                    transport) {
                currentTransport.accept(v);
            }
        }
    }
}