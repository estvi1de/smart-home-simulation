package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.devices.FreeObject;
import cz.cvut.fel.omo.model.devices.Fridge;
import cz.cvut.fel.omo.model.devices.GasDevice;
import cz.cvut.fel.omo.model.parts.*;
import cz.cvut.fel.omo.model.pets.Pet;
import cz.cvut.fel.omo.model.transport.Bike;
import cz.cvut.fel.omo.model.transport.Car;
import cz.cvut.fel.omo.model.transport.Ski;
import cz.cvut.fel.omo.model.transport.Transport;
import cz.cvut.fel.omo.model.users.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EventGenerator {
    private House house;
    private static EventGenerator instance = null;

    public static EventGenerator getInstance() {
        if (instance == null) {
            instance = new EventGenerator();
        }
        return instance;
    }

    private EventGenerator() {
    }

    public void setHouse(House house) {
        this.house = house;
    }

    private List<Device> devices() {
        List<Device> devices = new ArrayList();
        for (Level lvl : house.getLevels()) {
            for (Room room : lvl.getRooms()) {
                if (room.getDevices() != null)
                    devices.addAll(room.getDevices());
            }
        }
        return devices;
    }

    private List<Room> rooms() {
        List<Room> rooms = new ArrayList();
        for (Level lvl : house.getLevels()) {
            rooms.addAll(lvl.getRooms());
        }
        return rooms;
    }

    private List<Transport> sportEquipment() {
        List<Transport> sportEquipment = new ArrayList();
        for (Level lvl : house.getLevels()) {
            for (Room room : lvl.getRooms()) {
                if (room instanceof Garage && ((Garage) room).getTransport() != null) {
                    sportEquipment.addAll(((Garage) room).getTransport());
                }
            }
        }
        return sportEquipment;
    }

    public void generateLifeEvents() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
            System.out.println("                 ---------------------------");
            System.out.println("-------------------------------------------------------------------");
            Random rand = new Random();
            int randNumber = rand.nextInt(100);
            if (randNumber > 5) {
                System.out.println("                         " + (i + 1) + " of " + "25");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("                 ---------------------------");
                System.out.println();
                for (Person currentPerson : house.getResidents()) {
                    if (house.getResidents().indexOf(currentPerson) % 2 == i % 2) {
                        generateRandomEventWithDevice(currentPerson);
                    } else {
                        generateRandomEventWithSport(currentPerson);
                    }
                }
                for (Pet currentPet : house.getPets()) {
                    generateRandomMovingForPet(currentPet);
                }
                for (Person currentPerson : house.getResidents()) {
                    currentPerson.freeDevice();
                    currentPerson.freeTransport();
                }


                System.out.println();
                System.out.println("---------------------------------------------------------------");
                System.out.println("Consumption for " + (i + 1) + " of " + "25");
                System.out.println("---------------------------------------------------------------");
                System.out.println();
                System.out.println("Electricity consumption:");
                house.getPowerOutagesSignalization().notifyObservers(3);
                System.out.println();
                System.out.println("Gas consumption:");
                house.getGasLeakSignalization().notifyObservers(3);
                System.out.println();
                System.out.println("Water consumption:");
                house.getWaterLeakSignalization().notifyObservers(3);


                int brokeChance = rand.nextInt(100);
                if (brokeChance < 10) {
                    Device brokenDevice = devices().get(rand.nextInt(devices().size()));
                    brokenDevice.setBrokenStatus(true);
                }
            } else {
                System.out.println("                     " + (i + 1) + " of " + " 25 SERIOUS EVENT");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("                 ---------------------------");
                System.out.println();
                generateSeriousEvent();
            }
        }
    }

    private void generateRandomEventWithDevice(Person person) {
        Random rand = new Random();
        Device currentDevice = devices().get(rand.nextInt(devices().size()));
        person.goToRoom(currentDevice.getRoom());
        if (person.getCurrentRoom() == currentDevice.getRoom()) {
            if (currentDevice instanceof Fridge) {
                int rand_int = rand.nextInt(4);
                switch (rand_int) {
                    case 0 -> person.onDevice(currentDevice);
                    case 1 -> person.offDevice(currentDevice);
                    case 2 -> person.giveFoodToFridge((Fridge) currentDevice, rand.nextInt(80));
                    case 3 -> person.takeFood((Fridge) currentDevice, rand.nextInt(40));
                }
            } else if (currentDevice instanceof FreeObject) {
                int rand_int = rand.nextInt(3);
                switch (rand_int) {
                    case 0 -> person.onDevice(currentDevice);
                    case 1 -> person.offDevice(currentDevice);
                    case 2 -> person.occupyDevice((FreeObject) currentDevice);
                }
            } else {
                int rand_int = rand.nextInt(2);
                switch (rand_int) {
                    case 0 -> person.onDevice(currentDevice);
                    case 1 -> person.offDevice(currentDevice);
                }
            }
        }
    }

    private void generateRandomEventWithSport(Person person) {
        Random rand = new Random();
        Transport currentEquipment = sportEquipment().get(rand.nextInt(sportEquipment().size()));
        person.goToRoom(currentEquipment.getGarage());
        if (person.getCurrentRoom() == currentEquipment.getGarage()) {
            if (currentEquipment instanceof Car) {
                int rand_int = rand.nextInt(2);
                switch (rand_int) {
                    case 0 -> person.driveTransport((Car) currentEquipment);
                    case 1 -> person.sitInCar((Car) currentEquipment);
                }
            } else if (currentEquipment instanceof Bike) {
                person.driveTransport((Bike) currentEquipment);
            } else if (currentEquipment instanceof Ski) {
                person.driveTransport((Ski) currentEquipment);
            }
        }
    }

    private void generateRandomMovingForPet(Pet pet) {
        Random rand = new Random();
        Room room = rooms().get(rand.nextInt(rooms().size()));
        pet.goToRoom(room);
    }

    private void generateSeriousEvent() {
        Random rand = new Random();
        Person checker = house.getResidents().stream().
                filter(x -> x.getAge() >= 18).
                collect(Collectors.toList()).
                get(rand.nextInt(house.getResidents().stream().filter(x -> x.getAge() >= 18).collect(Collectors.toList()).size()));
        int randNumber = rand.nextInt(4);
        switch (randNumber) {
            case 0:
                house.getGasLeakSignalization().allOff();
                for (GasDevice device : house.getGasLeakSignalization().getAllGasDevices())
                    checker.goToRoom(((Device) device).getRoom());
                house.getGasLeakSignalization().allOn();
                break;
            case 1:
                house.getPowerOutagesSignalization().allOff();
                for (Room room : rooms()) {
                    checker.goToRoom(room);
                }
                house.getPowerOutagesSignalization().allOn();
                break;
            case 2:
                house.getWaterLeakSignalization().allOff();
                for (Room room : rooms()) {
                    checker.goToRoom(room);
                }
                house.getWaterLeakSignalization().allOn();
                break;
            case 3:
                int temperature = rand.nextInt(55);
                house.getFireSignalization().checkSmoke(temperature + 70);
                house.getFireSignalization().stabilize();
                break;
        }
    }
}