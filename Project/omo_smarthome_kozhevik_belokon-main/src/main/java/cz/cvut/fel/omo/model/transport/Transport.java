package cz.cvut.fel.omo.model.transport;

import cz.cvut.fel.omo.model.parts.Garage;
import cz.cvut.fel.omo.model.users.Person;
import cz.cvut.fel.omo.visitor.CustomVisitor;
import cz.cvut.fel.omo.visitor.Visit;

public abstract class Transport implements Visit {
    private Integer capacityOfPersons;
    private Person driver;
    private Integer volume;
    private Garage garage;

    Transport(Integer capacityOfPersons, Integer volume, Garage garage) {
        this.capacityOfPersons = capacityOfPersons;
        this.volume = volume;
        this.garage = garage;
    }

    public Integer getCapacityOfPersons() {
        return capacityOfPersons;
    }

    public void setCapacityOfPersons(Integer capacityOfPersons) {
        this.capacityOfPersons = capacityOfPersons;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void accept(CustomVisitor v) {
        v.visitTransport(this);
    }
}