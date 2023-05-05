package cz.cvut.fel.omo.model.signalization;

import cz.cvut.fel.omo.model.devices.GasDevice;
import cz.cvut.fel.omo.observer.Observable;
import cz.cvut.fel.omo.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class GasLeakSignalization implements Signalization, Observable {
    private List<GasDevice> devices = new ArrayList<>();
    private double summaryConsumption = 0;

    public List<GasDevice> getAllGasDevices() {
        return devices;
    }

    public void allOff() {
        System.out.println("Problems with gas! All gas-devices are off!");
        notifyObservers(1);

    }

    public void allOn() {
        System.out.println("Problems with gas are solved! All gas-devices are on!");
        notifyObservers(2);
    }

    @Override
    public void notifyObservers(int code) {
        if (code == 1) {
            for (GasDevice device : devices) {
                device.update(3);
            }
        }
        if (code == 2) {
            for (GasDevice device : devices) {
                device.update(2);
            }
        } else if (code == 3) {
            for (GasDevice device : devices) {
                device.update(4);
            }
            double newSummaryConsumption = 0;
            for (GasDevice device : devices) {
                newSummaryConsumption += device.getSummaryGasConsumption();
            }
            summaryConsumption = newSummaryConsumption;
        }
    }

    @Override
    public void subscribe(Observer observer) {
        devices.add((GasDevice) observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        devices.remove((GasDevice) observer);
    }

    public double getSummaryConsumption() {
        return summaryConsumption;
    }
}