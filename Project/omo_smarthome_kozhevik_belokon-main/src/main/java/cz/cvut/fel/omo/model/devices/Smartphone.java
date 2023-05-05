package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.users.Person;

public class Smartphone {
    private Person owner;

    public Smartphone(Person owner) {
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}