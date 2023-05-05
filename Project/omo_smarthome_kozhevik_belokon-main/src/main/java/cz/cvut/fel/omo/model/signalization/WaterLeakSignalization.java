package cz.cvut.fel.omo.model.signalization;

import cz.cvut.fel.omo.model.devices.WaterDevice;
import cz.cvut.fel.omo.observer.Observable;
import cz.cvut.fel.omo.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WaterLeakSignalization implements Signalization, Observable {
    private List<WaterDevice> devices = new ArrayList<>();
    private double summaryConsumption = 0;

    public void allOff() {
        System.out.println("Problems with water! All water-devices are off!");
        notifyObservers(1);
    }

    public void allOn() {
        System.out.println("Problems with water are solved! All water-devices are on!");
        notifyObservers(2);
    }

    @Override
    public void notifyObservers(int code) {
        if (code == 1) {
            for (WaterDevice device : devices) {
                device.update(3);
            }
        }
        if (code == 2) {
            for (WaterDevice device : devices) {
                device.update(2);
            }
        } else if (code == 3) {
            for (WaterDevice device : devices) {
                device.update(4);
            }
            double newSummaryConsumption = 0;
            for (WaterDevice device : devices) {
                newSummaryConsumption += device.getSummaryWaterConsumption();
            }
            summaryConsumption = newSummaryConsumption;
        }
    }

    @Override
    public void subscribe(Observer observer) {
        devices.add((WaterDevice) observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        devices.remove((WaterDevice) observer);
    }

    public double getSummaryConsumption() {
        return summaryConsumption;
    }
}