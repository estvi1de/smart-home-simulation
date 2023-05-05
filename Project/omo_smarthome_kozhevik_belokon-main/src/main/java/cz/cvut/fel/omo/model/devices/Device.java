package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.parts.Room;
import cz.cvut.fel.omo.observer.Observer;
import cz.cvut.fel.omo.visitor.CustomVisitor;
import cz.cvut.fel.omo.visitor.Visit;

public abstract class Device implements Observer, Visit {
    protected boolean brokenStatus;
    protected boolean enableStatus;
    protected boolean smartStatus;
    protected String title;
    protected Room room;
    protected double periodicalElectricityConsumption = 0;
    protected double summaryElectricityConsumption = 0;

    protected int condition = 100;

    public Device(boolean smartStatus, String title, Room room, double periodicalElectricityConsumption) {
        this.smartStatus = smartStatus;
        this.title = title;
        this.room = room;
        this.periodicalElectricityConsumption = periodicalElectricityConsumption;
    }

    public boolean isBrokenStatus() {
        return brokenStatus;
    }

    public boolean isEnableStatus() {
        return enableStatus;
    }

    public boolean isSmartStatus() {
        return smartStatus;
    }

    public void on() {
        this.enableStatus = true;
    }

    public void off() {
        this.enableStatus = false;
    }

    public void setBrokenStatus(boolean value) {
        this.brokenStatus = value;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setEnableStatus(boolean enableStatus) {
        this.enableStatus = enableStatus;
    }

    public void setSmartStatus(boolean smartStatus) {
        this.smartStatus = smartStatus;
    }

    public double getPeriodicalElectricityConsumption() {
        return periodicalElectricityConsumption;
    }

    public void setPeriodicalElectricityConsumption(double periodicalElectricityConsumption) {
        this.periodicalElectricityConsumption = periodicalElectricityConsumption;
    }

    public double getSummaryElectricityConsumption() {
        return summaryElectricityConsumption;
    }

    public void setSummaryElectricityConsumption(double summaryElectricityConsumption) {
        this.summaryElectricityConsumption = summaryElectricityConsumption;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected void decreaseCondition(int i) {
        condition -= i;
        if (condition < 0) {
            System.out.println("DEVICE " + title + "IS BROKEN!");
        }
    }

    @Override
    public void accept(CustomVisitor v) {
        v.visitDevice(this);
    }

    @Override
    public void update(int code) {
        if (code == 1) {
            if (!this.isBrokenStatus() && this.room.getElectricityStatus()) {
                if (this.isEnableStatus())
                    this.summaryElectricityConsumption += periodicalElectricityConsumption;
                System.out.println("Electricity consumption for " + title + " in " + room.getName() + " - " + String.format("%.2f", summaryElectricityConsumption) + " (" + String.format("%.2f", periodicalElectricityConsumption) + " per turn)");
            }
        }
    }
}