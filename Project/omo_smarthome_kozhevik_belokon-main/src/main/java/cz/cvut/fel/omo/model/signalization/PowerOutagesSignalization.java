package cz.cvut.fel.omo.model.signalization;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.parts.Room;
import cz.cvut.fel.omo.observer.Observable;
import cz.cvut.fel.omo.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class PowerOutagesSignalization implements Signalization, Observable {
    private List<Device> devices = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private double summaryConsumption = 0;

    public void allOff() {
        System.out.println("Problems with electricity! All devices are off.");
        notifyObservers(1);
    }

    public void allOn() {
        System.out.println("Problems with electricity were solved! Ok, all devices are on.");
        notifyObservers(2);
    }

    @Override
    public void notifyObservers(int code) {
        if (code == 1) {
            for (Room room : rooms) {
                room.update(1);
            }
        } else if (code == 2) {
            for (Room room : rooms) {
                room.update(2);
            }
        } else if (code == 3) {
            for (Device device : devices) {
                device.update(1);
            }
            double newSummaryConsumption = 0;
            for (Device device : devices) {
                newSummaryConsumption += device.getSummaryElectricityConsumption();
            }
            summaryConsumption = newSummaryConsumption;
        }
    }

    @Override
    public void subscribe(Observer observer) {
        if (observer instanceof Room) {
            rooms.add((Room) observer);
        } else if (observer instanceof Device) {
            devices.add((Device) observer);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        if (observer instanceof Room) {
            rooms.remove((Room) observer);
        } else if (observer instanceof Device) {
            devices.remove((Device) observer);
        }
    }

    public double getSummaryConsumption() {
        return summaryConsumption;
    }
}