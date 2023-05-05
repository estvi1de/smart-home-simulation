package cz.cvut.fel.omo.model.pets;

import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.HistoryOfEvents;
import cz.cvut.fel.omo.model.parts.Room;

public abstract class Pet {
    private String name;
    protected Room currentRoom;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void goToRoom(Room room) {
        if (currentRoom != null && room.getFreePlace() > 0) {
            Room oldRoom = currentRoom;
            currentRoom.getPetsInRoom().remove(this);
            currentRoom = room;
            room.getPetsInRoom().add(this);
            System.out.println(this.name + " (pet - " + this.getClass().getSimpleName() + ") went from - " + oldRoom.getName() + ", to - " + currentRoom.getName());
            HistoryOfEvents.addEvent(new Event(this, room));
        } else if (room.getFreePlace() > 0) {
            this.currentRoom = room;
            room.getPetsInRoom().add(this);
            System.out.println(this.name + " (pet - " + this.getClass().getSimpleName() + ") went to - " + currentRoom.getName());
            HistoryOfEvents.addEvent(new Event(this, room));
        } else {
            System.out.println(this.name + " (pet - " + this.getClass().getSimpleName() + ") can't go to room " + room.getName() + " because it's busy " + room.getFreePlace() + " of " + room.getCapacity());
        }
    }
}