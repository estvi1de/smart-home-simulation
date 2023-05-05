package cz.cvut.fel.omo.model.parts;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.pets.Pet;
import cz.cvut.fel.omo.model.signalization.*;
import cz.cvut.fel.omo.model.users.Account;
import cz.cvut.fel.omo.model.users.Person;
import cz.cvut.fel.omo.visitor.CustomVisitor;
import cz.cvut.fel.omo.visitor.Visit;

import java.util.ArrayList;
import java.util.List;

public class House implements Visit {
    private String address;
    private Account owner;
    private Outdoor outdoor;
    private List<Level> levels;
    private List<Person> residents;
    private List<Pet> pets;
    private PowerOutagesSignalization powerOutagesSignalization;
    private WaterLeakSignalization waterLeakSignalization;
    private GasLeakSignalization gasLeakSignalization;
    private FireSignalization fireSignalization;

    public House(String address, Account owner, List<Level> levels, Outdoor outdoor, PowerOutagesSignalization powerOutagesSignalization, WaterLeakSignalization waterLeakSignalization, GasLeakSignalization gasLeakSignalization, FireSignalization fireSignalization) {
        this.address = address;
        this.owner = owner;
        this.levels = levels;
        this.outdoor = outdoor;
        this.powerOutagesSignalization = powerOutagesSignalization;
        this.waterLeakSignalization = waterLeakSignalization;
        this.gasLeakSignalization = gasLeakSignalization;
        this.fireSignalization = fireSignalization;
    }

    public House(String address, Account owner, List<Level> levels, Outdoor outdoor, PowerOutagesSignalization powerOutagesSignalization, WaterLeakSignalization waterLeakSignalization, GasLeakSignalization gasLeakSignalization, FireSignalization fireSignalization, List<Person> residents) {
        this.address = address;
        this.owner = owner;
        this.levels = levels;
        this.outdoor = outdoor;
        this.residents = residents;
        this.powerOutagesSignalization = powerOutagesSignalization;
        this.waterLeakSignalization = waterLeakSignalization;
        this.gasLeakSignalization = gasLeakSignalization;
        this.fireSignalization = fireSignalization;
    }

    public House(String address, Account owner, List<Level> levels, Outdoor outdoor, PowerOutagesSignalization powerOutagesSignalization, WaterLeakSignalization waterLeakSignalization, GasLeakSignalization gasLeakSignalization, FireSignalization fireSignalization, List<Person> residents, List<Pet> pets) {
        this.address = address;
        this.owner = owner;
        this.levels = levels;
        this.outdoor = outdoor;
        this.residents = residents;
        this.pets = pets;
        this.powerOutagesSignalization = powerOutagesSignalization;
        this.waterLeakSignalization = waterLeakSignalization;
        this.gasLeakSignalization = gasLeakSignalization;
        this.fireSignalization = fireSignalization;
    }

    public House(String address, Account owner, List<Level> levels, Outdoor outdoor, PowerOutagesSignalization powerOutagesSignalization, WaterLeakSignalization waterLeakSignalization, GasLeakSignalization gasLeakSignalization, FireSignalization fireSignalization, List<Person> residents, List<Pet> pets,
                 List<Signalization> signalizationDetectors) {
        this.address = address;
        this.owner = owner;
        this.levels = levels;
        this.outdoor = outdoor;
        this.residents = residents;
        this.pets = pets;
        this.powerOutagesSignalization = powerOutagesSignalization;
        this.waterLeakSignalization = waterLeakSignalization;
        this.gasLeakSignalization = gasLeakSignalization;
        this.fireSignalization = fireSignalization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public Outdoor getOutdoor() {
        return outdoor;
    }

    public void setOutdoor(Outdoor outdoor) {
        this.outdoor = outdoor;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public List<Person> getResidents() {
        return residents;
    }

    public void setResidents(List<Person> residents) {
        this.residents = residents;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Device> getAllDevices() {
        List<Device> devices = new ArrayList();
        for (Level lvl : levels) {
            for (Room room : lvl.getRooms()) {
                devices.addAll(room.getDevices());
            }
        }
        return devices;
    }

    public PowerOutagesSignalization getPowerOutagesSignalization() {
        return powerOutagesSignalization;
    }

    public void setPowerOutagesSignalization(PowerOutagesSignalization powerOutagesSignalization) {
        this.powerOutagesSignalization = powerOutagesSignalization;
    }

    public WaterLeakSignalization getWaterLeakSignalization() {
        return waterLeakSignalization;
    }

    public void setWaterLeakSignalization(WaterLeakSignalization waterLeakSignalization) {
        this.waterLeakSignalization = waterLeakSignalization;
    }

    public GasLeakSignalization getGasLeakSignalization() {
        return gasLeakSignalization;
    }

    public void setGasLeakSignalization(GasLeakSignalization gasLeakSignalization) {
        this.gasLeakSignalization = gasLeakSignalization;
    }

    public FireSignalization getFireSignalization() {
        return fireSignalization;
    }

    public void setFireSignalization(FireSignalization fireSignalization) {
        this.fireSignalization = fireSignalization;
    }

    @Override
    public void accept(CustomVisitor v) {
        v.visitHouse(this);
        for (Person currentPerson :
                residents) {
            currentPerson.accept(v);
        }
        for (Level currentLevel :
                levels) {
            currentLevel.accept(v);
        }
    }
}