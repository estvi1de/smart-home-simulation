package cz.cvut.fel.omo.model.transport;

import cz.cvut.fel.omo.model.parts.Garage;
import cz.cvut.fel.omo.model.users.Person;

import java.util.ArrayList;
import java.util.List;

public class Car extends Transport {
    private List<Person> passengers = new ArrayList<>();

    public Car(Integer capacityOfPersons, Integer volume, Garage garage) {
        super(capacityOfPersons, volume, garage);
    }

    public void setPassengers(List<Person> people) {
        this.passengers = people;
    }

    public List<Person> getPassengers() {
        return passengers;
    }
}