package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.parts.Room;

public class GasCooker extends Device implements FreeObject, GasDevice {
    private Boolean freeStatus = true;
    protected double periodicalGasConsumption = 0;
    protected double summaryGasConsumption = 0;
    private Boolean gasStatus = true;

    public GasCooker(String name, Room room, double periodicalElectricityConsumption, double periodicalGasConsumption) {
        super(false, name, room, periodicalElectricityConsumption);
        this.periodicalGasConsumption = periodicalGasConsumption;
    }

    public Boolean getFreeStatus() {
        return freeStatus;
    }

    public void setFreeStatus(Boolean status) {
        this.freeStatus = status;
    }

    @Override
    public double getPeriodicalGasConsumption() {
        return periodicalGasConsumption;
    }

    @Override
    public void setPeriodicalGasConsumption(double periodicalGasConsumption) {
        this.periodicalGasConsumption = periodicalGasConsumption;
    }

    @Override
    public double getSummaryGasConsumption() {
        return summaryGasConsumption;
    }

    @Override
    public void setSummaryGasConsumption(double summaryGasConsumption) {
        this.summaryGasConsumption = summaryGasConsumption;
    }

    public Boolean getGasStatus() {
        return gasStatus;
    }

    public void setGasStatus(Boolean gasStatus) {
        this.gasStatus = gasStatus;
    }

    @Override
    public void update(int code) {
        if (!this.isBrokenStatus() && this.room.getElectricityStatus()) {
            if (code == 1) {
                super.update(1);
            } else if (code == 2) {
                this.gasStatus = true;
                System.out.println("GasDevice ("+ title +") is on");
            } else if (code == 3) {
                this.gasStatus = false;
                System.out.println("GasDevice ("+ title + ") is off");
            } else if (code == 4 && this.gasStatus) {
                if (this.isEnableStatus())
                    this.summaryGasConsumption += this.periodicalGasConsumption;
                System.out.println("Gas consumption for " + title + " in " + room.getName() + " - " + String.format("%.2f", summaryGasConsumption) + " (" + String.format("%.2f", periodicalGasConsumption) + " per turn)");
            }
        }
    }
}