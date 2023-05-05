package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.parts.Room;
import cz.cvut.fel.omo.model.pets.Pet;
import cz.cvut.fel.omo.model.transport.Transport;
import cz.cvut.fel.omo.model.users.Person;

public class Event {
    private Room room;
    private Person person;
    private Device device;
    private Transport transport;
    private Pet pet;

    public Event(Person person, Device device) {
        this.person = person;
        this.device = device;
    }

    public Event(Pet pet, Room room) {
        this.pet = pet;
        this.room = room;
    }

    public Event(Person person, Room room) {
        this.person = person;
        this.room = room;
    }

    public Event(Person person, Transport transport) {
        this.person = person;
        this.transport = transport;
    }


    @Override
    public String toString() {
        if (pet != null) {
            return "Event{" +
                    "pet: " + pet.getName() +
                    ", room: " + room.getName() +
                    '}';
        } else if (device != null) {
            return "Event{" +
                    "person: " + person.getName() +
                    ", device: " + device.getTitle() +
                    ", room: " + device.getRoom().getName() +
                    '}';
        } else if (transport != null) {
            return "Event{" +
                    "person: " + person.getName() +
                    ", transport: " + transport.getClass().getName() +
                    ", garage: " + transport.getGarage().getName() +
                    '}';
        } else if (room != null) {
            return "Event{" +
                    "person: " + person.getName() +
                    ", room: " + room.getName() +
                    '}';
        }
        return "fail";
    }
}