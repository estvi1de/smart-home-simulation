package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.parts.Room;

public class WashingMachine extends Device implements FreeObject, WaterDevice {
    private Boolean freeStatus = true;
    protected double periodicalWaterConsumption;
    protected double summaryWaterConsumption = 0;
    private Boolean waterStatus = true;

    public WashingMachine(String name, Room room, double periodicalElectricityConsumption, double periodicalWaterConsumption) {
        super(false, name, room, periodicalElectricityConsumption);
        this.periodicalWaterConsumption = periodicalWaterConsumption;
    }

    public Boolean getFreeStatus() {
        return freeStatus;
    }

    public void setFreeStatus(Boolean status) {
        this.freeStatus = status;
    }

    @Override
    public double getPeriodicalWaterConsumption() {
        return periodicalWaterConsumption;
    }

    @Override
    public void setPeriodicalWaterConsumption(double periodicalWaterConsumption) {
        this.periodicalWaterConsumption = periodicalWaterConsumption;
    }

    @Override
    public double getSummaryWaterConsumption() {
        return summaryWaterConsumption;
    }

    @Override
    public void setSummaryWaterConsumption(double summaryWaterConsumption) {
        this.summaryWaterConsumption = summaryWaterConsumption;
    }

    @Override
    public void update(int code) {
        if (!this.isBrokenStatus() && room.getElectricityStatus()) {
            if (code == 1) {
                super.update(1);
            } else if (code == 2) {
                this.waterStatus = true;
                System.out.println("WaterDevice (" + title + ") is on");
            } else if (code == 3) {
                this.waterStatus = false;
                System.out.println("WaterDevice (" + title + ") is off");
            } else if (code == 4 && this.waterStatus) {
                if (this.isEnableStatus())
                    this.summaryWaterConsumption += this.periodicalWaterConsumption;
                System.out.println("Water consumption for " + title + " in " + room.getName() + " - " + String.format("%.2f", summaryWaterConsumption) + " (" + String.format("%.2f", periodicalWaterConsumption) + " per turn)");
            }
        }
    }
}