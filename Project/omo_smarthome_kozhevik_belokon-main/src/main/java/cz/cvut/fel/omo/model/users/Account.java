package cz.cvut.fel.omo.model.users;

import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.HistoryOfEvents;
import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.devices.FreeObject;

public class Account extends Person {
    private String password;
    private String phoneNumber;
    private String username;

    public Account(String name, Integer age, String password, String phoneNumber, String username) {
        super(name, age);
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void onDevice(Device device) {
        if ((device.isSmartStatus() || (currentRoom!=null && currentRoom == device.getRoom())) && !device.isBrokenStatus() && (!(device instanceof FreeObject) || ((FreeObject) device).getFreeStatus())) {
            device.on();
            System.out.println(this.name + " turned on " + device.getTitle());
            HistoryOfEvents.addEvent(new Event(this, device));
        }
        else if (device.isBrokenStatus()){
            System.out.println(this.name + " must repair this device");
            repairDevice(device);
        }
        else if (device instanceof FreeObject && !((FreeObject) device).getFreeStatus()){
            System.out.println(this.name + " can't use this device " + device.getTitle() + ", because someone else uses it");
        }
        else if (!device.isEnableStatus()){
            System.out.println(this.name + " didn't turn off " + device.getTitle() + ", because it's already off");
        }
    }

    @Override
    public void offDevice(Device device) {
        if (device.isEnableStatus() && (device.isSmartStatus() || (currentRoom!=null && currentRoom == device.getRoom())) && !device.isBrokenStatus() && (!(device instanceof FreeObject) || ((FreeObject) device).getFreeStatus())) {
            device.off();
            System.out.println(this.name + " turned off " + device.getTitle());
            HistoryOfEvents.addEvent(new Event(this, device));
        }
        else if (device.isBrokenStatus()){
            System.out.println(this.name + " must repair this device");
            repairDevice(device);
        }
        else if (device instanceof FreeObject && !((FreeObject) device).getFreeStatus()){
            System.out.println(this.name + " can't use this device " + device.getTitle() + ", because someone else uses it");
        }
        else if (!device.isEnableStatus()){
            System.out.println(this.name + " didn't turn off " + device.getTitle() + ", because it's already off");
        }
    }
}