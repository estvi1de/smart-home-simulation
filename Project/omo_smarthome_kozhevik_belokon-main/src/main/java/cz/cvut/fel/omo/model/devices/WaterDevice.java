package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.observer.Observer;

public interface WaterDevice extends Observer {
    double getPeriodicalWaterConsumption();

    void setPeriodicalWaterConsumption(double periodicalWaterConsumption);

    double getSummaryWaterConsumption();

    void setSummaryWaterConsumption(double summaryWaterConsumption);
}