package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.observer.Observer;

public interface GasDevice extends Observer {
    double getPeriodicalGasConsumption();

    void setPeriodicalGasConsumption(double periodicalGasConsumption);

    double getSummaryGasConsumption();

    void setSummaryGasConsumption(double summaryGasConsumption);
}