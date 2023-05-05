package cz.cvut.fel.omo.model.parts;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.pets.Pet;
import cz.cvut.fel.omo.model.users.Person;
import cz.cvut.fel.omo.observer.Observer;
import cz.cvut.fel.omo.visitor.CustomVisitor;
import cz.cvut.fel.omo.visitor.Visit;

import java.util.ArrayList;
import java.util.List;

public class Room implements Visit, Observer {
    protected List<Person> peopleInRoom = new ArrayList<Person>();
    protected Integer capacity;
    protected Double square;
    private Level level;
    protected List<Pet> petsInRoom = new ArrayList<Pet>();;
    protected String name;
    protected List<Device> devices;
    protected Boolean electricityStatus = true;
    
    public Room(Integer capacity, Double square, Level level, String name) {
        this.capacity = capacity;
        this.square = square;
        this.level = level;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Person> getPeopleInRoom() {
        return peopleInRoom;
    }

    public void setPeopleInRoom(List<Person> peopleInRoom) {
        this.peopleInRoom = peopleInRoom;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Pet> getPetsInRoom() {
        return petsInRoom;
    }

    public void setPetsInRoom(List<Pet> petsInRoom) {
        this.petsInRoom = petsInRoom;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public Boolean getElectricityStatus() {
        return electricityStatus;
    }

    public void setElectricityStatus(Boolean electricityStatus) {
        this.electricityStatus = electricityStatus;
    }

    public Integer getFreePlace() {
        if (peopleInRoom != null && petsInRoom != null && capacity > peopleInRoom.size() + petsInRoom.size())
            return capacity - peopleInRoom.size() - petsInRoom.size();
        else if (petsInRoom != null && capacity > petsInRoom.size())
            return capacity - petsInRoom.size();
        else if (peopleInRoom != null && capacity > peopleInRoom.size())
            return capacity - peopleInRoom.size();
        return 0;
    }

    @Override
    public void accept(CustomVisitor v) {
        v.visitRoom(this);
        if (devices != null) {
            for (Device currentDevice :
                    devices) {
                currentDevice.accept(v);
            }
        }
    }

    @Override
    public void update(int code) {
        if (code == 1) {
            this.electricityStatus = false;
            System.out.println("Power for " + this.name + " was off");
        } else if (code == 2) {
            this.electricityStatus = true;
            System.out.println("Power for " + this.name + " was on");
        }
    }
}