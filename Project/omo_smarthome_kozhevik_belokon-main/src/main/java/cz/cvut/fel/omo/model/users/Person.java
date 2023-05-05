package cz.cvut.fel.omo.model.users;

import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.HistoryOfEvents;
import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.devices.FreeObject;
import cz.cvut.fel.omo.model.devices.Fridge;
import cz.cvut.fel.omo.model.parts.Room;
import cz.cvut.fel.omo.model.transport.Bike;
import cz.cvut.fel.omo.model.transport.Car;
import cz.cvut.fel.omo.model.transport.Ski;
import cz.cvut.fel.omo.model.transport.Transport;
import cz.cvut.fel.omo.visitor.CustomVisitor;
import cz.cvut.fel.omo.visitor.Visit;

public class Person implements Visit {
    protected Integer age;
    protected String name;
    protected Room currentRoom;
    protected FreeObject currentDevice;
    protected Transport currentTransport;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public FreeObject getCurrentDevice() {
        return currentDevice;
    }

    public void setCurrentDevice(FreeObject currentDevice) {
        this.currentDevice = currentDevice;
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    public void setCurrentTransport(Transport currentTransport) {
        this.currentTransport = currentTransport;
    }

    public void goToRoom(Room room) {
        if (room.getFreePlace() > 0 && currentRoom != null) {
            Room oldRoom = currentRoom;
            currentRoom.getPeopleInRoom().remove(this);
            this.currentRoom = room;
            room.getPeopleInRoom().add(this);
            System.out.println(this.name + " went from - " + oldRoom.getName() + ", to - " + currentRoom.getName());
            HistoryOfEvents.addEvent(new Event(this, room));
        } else if (room.getFreePlace() > 0) {
            this.currentRoom = room;
            room.getPeopleInRoom().add(this);
            System.out.println(this.name + " went to - " + currentRoom.getName());
            HistoryOfEvents.addEvent(new Event(this, room));
        } else {
            System.out.println(this.name + " can't go to room " + room.getName() + " because it's busy " + room.getFreePlace() + " of " + room.getCapacity());
        }
    }

    public void onDevice(Device device) {
        if (currentRoom == device.getRoom() && !device.isBrokenStatus() && (!(device instanceof FreeObject) || ((FreeObject) device).getFreeStatus())) {
            device.on();
            System.out.println(this.name + " turned on " + device.getTitle());
            HistoryOfEvents.addEvent(new Event(this, device));
        } else if (device.isBrokenStatus()) {
            System.out.println(this.name + " must repair this device");
            repairDevice(device);
        } else if (device instanceof FreeObject && !((FreeObject) device).getFreeStatus()) {
            System.out.println(this.name + " can't use this device " + device.getTitle() + ", because someone else uses it");
        }
    }

    public void offDevice(Device device) {
        if (device.isEnableStatus() && currentRoom == device.getRoom() && !device.isBrokenStatus() && (!(device instanceof FreeObject) || ((FreeObject) device).getFreeStatus())) {
            device.off();
            System.out.println(this.name + " turned off " + device.getTitle());
            HistoryOfEvents.addEvent(new Event(this, device));
        } else if (device.isBrokenStatus()) {
            System.out.println(this.name + " must repair this device");
            repairDevice(device);
        } else if (device instanceof FreeObject && !((FreeObject) device).getFreeStatus()) {
            System.out.println(this.name + " can't use this device " + device.getTitle() + ", because someone else uses it");
        } else if (!device.isEnableStatus()) {
            System.out.println(this.name + " didn't turn off " + device.getTitle() + ", because it's already off");
        }
    }

    public void driveTransport(Bike bike) {
        if (bike.getDriver() == null && bike.getGarage() == this.currentRoom) {
            this.currentTransport = bike;
            bike.setDriver(this);
            this.setCurrentRoom(bike.getGarage());
            System.out.println(this.name + " is driver of bike");
            HistoryOfEvents.addEvent(new Event(this, bike));
        } else if (bike.getDriver() != null) {
            System.out.println(this.name + " can't drive bike, because it's already busy");
        }
    }

    public void driveTransport(Ski ski) {
        if (ski.getDriver() == null && ski.getGarage() == this.currentRoom) {
            this.currentTransport = ski;
            ski.setDriver(this);
            this.setCurrentRoom(ski.getGarage());
            System.out.println(this.name + " is driver of ski");
            HistoryOfEvents.addEvent(new Event(this, ski));
        } else if (ski.getDriver() != null) {
            System.out.println(this.name + " can't use ski, because it's already busy");
        }
    }

    public void driveTransport(Car car) {
        if (car.getDriver() == null && age >= 18) {
            this.currentTransport = car;
            car.setDriver(this);
            currentRoom.getPeopleInRoom().remove(this);
            car.getPassengers().add(this);
            this.setCurrentRoom(null);
            System.out.println(this.name + " is driver of car");
            HistoryOfEvents.addEvent(new Event(this, car));
        } else if (age < 18) {
            sitInCar(car);
            System.out.println(this.name + " is passenger of car, because he isn't 18 y.o.");
        } else if (car.getDriver() != null) {
            sitInCar(car);
            System.out.println(this.name + " can't driver car, because it has a driver");
        }
    }

    public void freeTransport() {
        if (currentTransport != null) {
            if (currentTransport instanceof Bike) {
                currentTransport.setDriver(null);
            }
            if (currentTransport instanceof Ski) {
                currentTransport.setDriver(null);
            }
            if (currentTransport instanceof Car) {
                ((Car) currentTransport).getPassengers().remove(this);
                if (currentTransport.getDriver() == this) {
                    currentTransport.setDriver(null);
                }
            }
            System.out.println(this.name + " isn't passenger of " + currentTransport.getClass().getSimpleName());
            goToRoom(currentTransport.getGarage().getLevel().getHouse().getOutdoor());
            this.currentTransport = null;
        }
    }

    public void sitInCar(Car car) {
        if (car.getPassengers() == null || car.getPassengers().size() < car.getCapacityOfPersons()) {
            car.getPassengers().add(this);
            currentRoom.getPeopleInRoom().remove(this);
            this.currentRoom = null;
            HistoryOfEvents.addEvent(new Event(this, car));
            this.currentTransport = car;
            System.out.println(this.name + " is passenger of car");
        } else {
            System.out.println(this.name + " isn't passenger of car, because it's busy (" + car.getCapacityOfPersons() + " max)");
        }
    }


    public void repairDevice(Device device) {
        if (currentRoom == device.getRoom() && device.isBrokenStatus()) {
            device.setBrokenStatus(false);
            HistoryOfEvents.addEvent(new Event(this, device));
            System.out.println("Device " + device.getTitle() + " was repaired by " + this.name);
        }
    }

    public void takeFood(Fridge fridge, Integer food) {
        if (currentRoom == fridge.getRoom() && !fridge.isBrokenStatus()) {
            if (fridge.getFoodEnergy() > food) {
                fridge.setFoodEnergy(fridge.getFoodEnergy() - food);
                HistoryOfEvents.addEvent(new Event(this, fridge));
                System.out.println(this.getName() + " took food " + food + " from " + fridge.getTitle() + ". " + fridge.getFoodEnergy());
            } else {
                fridge.setFoodEnergy(0);
                HistoryOfEvents.addEvent(new Event(this, fridge));
                System.out.println(this.getName() + " took all the food from " + fridge.getTitle());
            }
        } else if (fridge.isBrokenStatus()) {
            System.out.println(this.name + " must repair fridge - " + fridge.getTitle());
            repairDevice(fridge);
        }
    }

    public void giveFoodToFridge(Fridge fridge, Integer food) {
        if (currentRoom == fridge.getRoom() && !fridge.isBrokenStatus()) {
            fridge.setFoodEnergy(fridge.getFoodEnergy() + food);
            HistoryOfEvents.addEvent(new Event(this, fridge));
            System.out.println(this.getName() + " gave " + food + " food to " + fridge.getTitle() + ". " + fridge.getFoodEnergy());
        } else if (fridge.isBrokenStatus()) {
            System.out.println(this.name + " must repair fridge - " + fridge.getTitle());
            repairDevice(fridge);
        }
    }

    public void occupyDevice(FreeObject device) {
        if (device.getRoom() == currentRoom) {
            device.setFreeStatus(false);
            this.currentDevice = device;
            HistoryOfEvents.addEvent(new Event(this, (Device) currentDevice));
            System.out.println(this.name + " occupied device" + device.getTitle());
        }
    }

    public void freeDevice() {
        if (currentDevice != null) {
            currentDevice.setFreeStatus(true);
            HistoryOfEvents.addEvent(new Event(this, (Device) currentDevice));
            System.out.println(currentDevice.getTitle() + " is free, " + this.name + " doesn't use it");
            this.currentDevice = null;
        }
    }

    @Override
    public void accept(CustomVisitor v) {
        v.visitPerson(this);
    }
}